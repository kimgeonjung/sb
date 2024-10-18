package edu.du.project1008;

import edu.du.project1008.dao.ArticleDao;
import edu.du.project1008.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class Project1008ApplicationTests {

    @Autowired
    ArticleDao articleDao;

    @Test
    void 게시판건수_출력() {
        System.out.println(articleDao.selectCount());
    }

    @Test
    void 게시글목록_출력() {
        List<Article> articles = articleDao.select(1, 10);
        articles.forEach(System.out::println);
    }

    @Test
    void 게시글_삽입() {
        Article article = new Article();
        article.setGroupId(1);
        article.setSequenceNumber("001");
        article.setPostingDate(new Timestamp(System.currentTimeMillis()));
        article.setWriterName("테스터");
        article.setPassword("password12");
        article.setTitle("테스트 글");
        article.setContent("테스트 내용");

        int insertedId = articleDao.insert(article);
        System.out.println("삽입한 Article ID: " + insertedId);
    }

    @Test
    void 게시글_조회() {
        int articleId = 9; // 조회할 게시글의 ID
        Article article = articleDao.selectById(articleId);
        System.out.println(article);
    }

    @Test
    void 조회수_증가() {
        int articleId = 9; // 조회수를 증가시킬 게시글의 ID
        articleDao.increaseReadCount(articleId);
        Article article = articleDao.selectById(articleId);
        System.out.println("수정된 Read Count: " + article.getReadCount());
    }

    @Test
    void 마지막시퀀스번호_조회() {
        String maxSeqNum = "002";
        String minSeqNum = "001";
        String lastSeqNum = articleDao.selectLastSequenceNumber(maxSeqNum, minSeqNum);
        System.out.println("마지막 Sequence Number: " + lastSeqNum);
    }

    @Test
    void 게시글_수정() {
        int articleId = 9; // 수정할 게시글의 ID
        Article article = articleDao.selectById(articleId);
        article.setTitle("수정된 제목");
        article.setContent("수정된 내용");
        int updateCount = articleDao.update(article);
        System.out.println("수정된 Rows: " + updateCount);
    }

    @Test
    void 게시글_삭제() {
        int articleId = 9; // 삭제할 게시글의 ID
        articleDao.delete(articleId);
        System.out.println("삭제된 Article ID: " + articleId);
    }



}
