package ink.poesy.my.service.Impl;

import ink.poesy.my.mapper.ArticleMapper;
import ink.poesy.my.pojo.Article;
import ink.poesy.my.pojo.ArticleShow;
import ink.poesy.my.service.ArticleServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServletImpl implements ArticleServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServletImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询所有的文章列表，没有分页
     * @return Article列表
     */
    @Override
    public List<ArticleShow> selectAllShowArticle() {
        List<ArticleShow> articleList = null;
        articleList = articleMapper.selectAllShowArticle();
        if(null != articleList){
            LOGGER.info("查询所有的文章：");
            LOGGER.info(articleList.toString());
        }else{
            LOGGER.error("查询文章为空");
        }
        return articleList;
    }

    @Override
    public List<ArticleShow> selectNewArticle() {
        List<ArticleShow> articleList = null;
        articleList = articleMapper.selectNewShowArticle();
        if(null != articleList){
            LOGGER.info("查询所有的文章：");
            LOGGER.info(articleList.toString());
        }else{
            LOGGER.error("查询文章为空");
        }
        return articleList;
    }

    @Override
    public String getArticleForId(int articleId) {
        String context = articleMapper.getArticleForId(articleId);
        if(null != context || !context.equals("")){
            LOGGER.info("文章内容获取成功！");
            LOGGER.info("content:"+context);
            return context;
        }else{
            LOGGER.error("文章内容获取失败！");
            return null;
        }
    }
}
