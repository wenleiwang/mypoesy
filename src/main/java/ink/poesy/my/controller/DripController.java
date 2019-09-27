package ink.poesy.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/drip")
public class DripController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogsController.class);

    @RequestMapping("/index")
    public String goIndex(){
        return "dripindex";
    }

    @RequestMapping("/test.html")
    public String goTest(){
        return "drip/test.html";
    }
}
