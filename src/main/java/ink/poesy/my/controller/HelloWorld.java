package ink.poesy.my.controller;

import ink.poesy.my.pojo.User;
import ink.poesy.my.service.UserServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorld {

    Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    UserServlet librarianService;

    @GetMapping("/hello")
    public String getALibrarianInfo() {
        return "wo";
    }


    @RequestMapping("/test")
    public String goTest1(){
        return "drip/test.html";
    }
}
