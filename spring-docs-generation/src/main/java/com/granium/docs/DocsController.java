package com.granium.docs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sasha.Chepurnoi on 10.02.17.
 */
@Controller
public class DocsController {


    @RequestMapping("/docs")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
