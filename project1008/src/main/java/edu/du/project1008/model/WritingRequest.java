package edu.du.project1008.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
public class WritingRequest {
    private String writerName;
    private String password;
    private String title;
    private String content;

    public Article toArticle() {
        Article article = new Article();
        article.setWriterName(writerName);
        article.setPassword(password);
        article.setTitle(title);
        article.setContent(content);
        return article;
    }
}
