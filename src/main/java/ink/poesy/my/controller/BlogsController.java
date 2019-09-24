package ink.poesy.my.controller;

import ink.poesy.my.pojo.User;
import ink.poesy.my.service.UserServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogsController.class);

    @Autowired
    private UserServlet userServlet;

    @RequestMapping("/index.html")
    public String goBlogsIndex(){
        String userName = "wenlei";
        String userPassword = "123456";
        User user = userServlet.getUserInfo(userName,userPassword).get(0);
        System.out.println(user);
        return "blogs/index";
    }

    @RequestMapping("/404.html")
    public String goBlogs404(){ return "blogs/404"; }

    @RequestMapping("/cateogry.html")
    public String goBlogsCateogry(){ return "blogs/cateogry"; }

    @RequestMapping("/single-blog.html")
    public String goBlogsSingle(){ return "blogs/single-blog"; }

    @RequestMapping("/contact.html")
    public String goBlogsContact(){return "blogs/contact"; }
}
