package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * Created by kunrong on 14/9/14.
 */
@Controller

public class MyController {
    @RequestMapping(value ="/number/{randomId}", method = RequestMethod.GET)
    public String findRandom(@PathVariable String randomId,ModelMap model){
        Random random = new Random(Long.parseLong(randomId));
        model.addAttribute("randomId", random.nextInt());
        return "test";
    }
}
