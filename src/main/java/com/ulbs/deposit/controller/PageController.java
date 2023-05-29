package com.ulbs.deposit.controller;

import com.ulbs.deposit.entity.Cladiri;
import com.ulbs.deposit.entity.Echipament;
import com.ulbs.deposit.service.ICladiriService;
import com.ulbs.deposit.service.IEchipamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    ICladiriService cladiriService;

    @Autowired
    IEchipamenteService echipamenteService;

    @GetMapping(path = "/")
    public String getHomePage(){
        return "index";
    }

    //https://bootsnipp.com/snippets/AlkBV
    @GetMapping(path = "/Login")
    public String getLogin(){
        return "Login";
    }

}
