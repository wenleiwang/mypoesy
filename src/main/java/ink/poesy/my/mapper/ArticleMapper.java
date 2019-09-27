package ink.poesy.my.mapper;

import ink.poesy.my.pojo.ArticleShow;

import java.util.List;

public interface ArticleMapper {
    /**
     * 查询所有的文章，没有分页
     * @return
     */
    public List<ArticleShow> selectAllShowArticle();

    List<ArticleShow> selectNewShowArticle();

    String getArticleForId(int articleId);
}
