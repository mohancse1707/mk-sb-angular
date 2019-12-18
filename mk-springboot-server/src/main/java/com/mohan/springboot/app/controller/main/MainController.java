package com.mohan.springboot.app.controller.main;

import ch.qos.logback.classic.LoggerContext;
import com.mohan.springboot.app.model.token.TokenGenerator;
import com.mohan.springboot.app.service.usermanagement.GenerateTokenService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/mk")
public class MainController {

    @PostMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadHomePage(){
        String value = "rest is working";
        return value;
    }

    @GetMapping("/gethome" )
    public List<String> getList() {
       List<String> name = new ArrayList<>();
       name.add("Mohan");
       return name;
    }
}
