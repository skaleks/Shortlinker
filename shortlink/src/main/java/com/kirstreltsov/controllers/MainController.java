package com.kirstreltsov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

  @GetMapping
  public String startPage(){
    return "index";
  }

  @PostMapping
  public ModelAndView getTargetUrl(@ModelAttribute("url") String url) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("url", url);
    mav.setViewName("result");
    return mav;
  }

    // @GetMapping("{short}")
    // public ResponseEntity<String> redirectShorter(@PathVariable("short") String hash) {
        
		// return null;
    // }
}
