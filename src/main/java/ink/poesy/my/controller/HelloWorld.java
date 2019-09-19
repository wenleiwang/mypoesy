package ink.poesy.my.controller;

import ink.poesy.my.mapper.UserMapper;
import ink.poesy.my.pojo.User;
import ink.poesy.my.service.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    UserServlet librarianService;

    @GetMapping("/hello")
    public User getALibrarianInfo() {
        return librarianService.selectLibrarian();
    }

    public class wo{
        String name;
    }
}
