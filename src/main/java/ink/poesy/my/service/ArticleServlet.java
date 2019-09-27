package ink.poesy.my.service;

import ink.poesy.my.pojo.ArticleShow;

import java.util.List;


public interface ArticleServlet {
    public List<ArticleShow> selectAllShowArticle();

    List<ArticleShow> selectNewArticle();

    String getArticleForId(int articleId);
}
