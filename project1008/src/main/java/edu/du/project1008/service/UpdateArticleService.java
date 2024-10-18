package edu.du.project1008.service;

import edu.du.project1008.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateArticleService {
    @Autowired
    ArticleDao articleDao;


}
