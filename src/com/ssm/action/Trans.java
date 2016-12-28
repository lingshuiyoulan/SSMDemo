package com.ssm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/action")
public class Trans {
    @RequestMapping("/trans")
    public String trans(String url) {
        return "forward:/WEB-INF/manager/" + url;
    }
}
