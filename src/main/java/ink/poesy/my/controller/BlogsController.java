package ink.poesy.my.controller;

import ink.poesy.my.pojo.Article;
import ink.poesy.my.pojo.ArticleShow;
import ink.poesy.my.pojo.User;
import ink.poesy.my.service.ArticleServlet;
import ink.poesy.my.service.UserServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogsController.class);

    @Autowired
    private UserServlet userServlet;

    @Autowired
    private ArticleServlet articleServlet;

    /**
     * 跳转到博客首页，到有我的个人信息，文章列表（还没有进行分页），文章按时间排序的前9条
     * @param model 存储页面信息
     * @return 带有信息的页面
     */
    @RequestMapping("/index.html")
    public String goBlogsIndex(Model model){
        String userName = "wenlei";
        String userPassword = "123456";
        //用户验证登录信息
        User user = userServlet.getUserInfo(userName,userPassword);
        //查询所有文章展示列表
        List<ArticleShow> articlesList = articleServlet.selectAllShowArticle();
        //查询最新文章列表前9条
        List<ArticleShow> newList = articleServlet.selectNewArticle();
        if(null != user){
            model.addAttribute("USER",user);
            model.addAttribute("ARTICLES",articlesList);
            model.addAttribute("NEWLISTS",newList);
            return "blogs/index";
        }else{
            model.addAttribute("INFO","用户名或密码错误！");
            return "blogs/login";
        }
    }

    /**
     * 去往错误界面
     * @return 错误界面
     */
    @RequestMapping("/404.html")
    public String goBlogs404(){ return "blogs/404"; }

    @RequestMapping("/cateogry.html")
    public String goBlogsCateogry(){ return "blogs/cateogry"; }

    /**
     * 这里暂时没有用是个错误的地方，找时间修改
     * @return 页面
     */
    @RequestMapping("/single-blog.html")
    public String goBlogsSingle(){ return "blogs/single-blog"; }

    @RequestMapping("/contact.html")
    public String goBlogsContact(){return "blogs/contact"; }

    @RequestMapping("/goUpImg")
    public String goUploadImg(){
        LOGGER.info("来到这里！！！！！11111111111111111");
        return "blogs/uploadImg.html";
    }


    /**
     * 通过文章id获取文章内容
     * @param articleId 文章id
     * @return 带有文章内容的网页的地址
     */
    @GetMapping(value = "/{id}")
    public String goArticleParticulars(@PathVariable("id") int articleId, Model model){
        LOGGER.info("传入id"+articleId);
        String context =  articleServlet.getArticleForId(articleId);
        if(context == null){
            LOGGER.error("文章内容为null");
            model.addAttribute("INFO","文章丢失，帮忙留言提醒小主~");
            //重定向
            return "redirect:404.html";
        }else{
            LOGGER.info("返回文章内容。");
            model.addAttribute("CONTENT",context);
            return "blogs/single-blog.html";
            //return "drip/test.html";
        }
    }
}
