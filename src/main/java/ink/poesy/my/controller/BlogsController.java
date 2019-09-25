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
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/404.html")
    public String goBlogs404(){ return "blogs/404"; }

    @RequestMapping("/cateogry.html")
    public String goBlogsCateogry(){ return "blogs/cateogry"; }

    @RequestMapping("/single-blog.html")
    public String goBlogsSingle(){ return "blogs/single-blog"; }

    @RequestMapping("/contact.html")
    public String goBlogsContact(){return "blogs/contact"; }

    @RequestMapping("/goUpImg")
    public String goUploadImg(){
        LOGGER.info("来到这里！！！！！11111111111111111");
        return "blogs/uploadImg.html";
    }
}
