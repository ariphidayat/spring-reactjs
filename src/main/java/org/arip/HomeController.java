package org.arip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Arip Hidayat on 3/21/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
}
