package edu.du.project1008.dao;

import edu.du.project1008.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {
    @Select("select count(*) from article")
    public int selectCount();

    @Select("select article_id id, group_id groupId, sequence_no sequenceNumber, posting_date postingDate, read_count readCount, writer_name writerName, password, title from article order by sequence_no desc limit #{firstRow}, #{endRow}")
    public List<Article> select(int firstRow, int endRow);

    @Insert("insert into article (group_id, sequence_no, posting_date, read_count, writer_name, password, title, content) "
            + "values (#{article.groupId}, #{article.sequenceNumber}, #{article.postingDate}, 0, #{article.writerName}, #{article.password}, #{article.title}, #{article.content})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="article_id")
    public int insert(@Param("article") Article article);

    @Select("select article_id id, group_id groupId, sequence_no sequenceNumber, posting_date postingDate, read_count readCount, writer_name writerName, password, title, content from article where article_id = #{articleId}")
    public Article selectById(@Param("articleId") int articleId);

    @Update("update article set read_count = read_count + 1 where article_id = #{articleId}")
    public void increaseReadCount(@Param("articleId") int articleId);

    @Select("select min(sequence_no) from article where sequence_no < #{searchMaxSeqNum} and sequence_no >= #{searchMinSeqNum}")
    public String selectLastSequenceNumber(@Param("searchMaxSeqNum") String searchMaxSeqNum, @Param("searchMinSeqNum") String searchMinSeqNum);

    @Update("update article set title = #{title}, content = #{content} where article_id = #{id}")
    public int update(Article article);

    @Delete("delete from article where article_id = #{articleId}")
    public void delete(@Param("articleId") int articleId);

}
