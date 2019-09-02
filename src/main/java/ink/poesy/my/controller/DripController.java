package ink.poesy.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/drip")
public class DripController {

    @RequestMapping("/index")
    public String goIndex(){
        return "dripindex";
    }
}
