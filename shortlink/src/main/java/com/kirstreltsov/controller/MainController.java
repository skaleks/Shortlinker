package com.kirstreltsov.controller;

import java.io.IOException;
import com.kirstreltsov.service.ShortlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {


  @Autowired
  private final ShortlinkService service;

  @GetMapping
  public String startPage(){
    return "index";
  }

  @GetMapping("/{short}")
  public ResponseEntity redirect(@PathVariable("short") String shortUrl) {

    String targetUrl = service.findLongURLbyShort(shortUrl);

      if (targetUrl != null) {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Location", targetUrl);
          return new ResponseEntity<String>(headers, HttpStatus.FOUND);
      } else {
          return ResponseEntity.notFound().build();
      }
	}

  @RequestMapping(value = "/", consumes="application/json", produces = "application/json")
  public @ResponseBody String createShortUrl(@RequestBody String originalUrl) throws IOException{

    return service.saveUrltoDB(originalUrl);
  }
}
