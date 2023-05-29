package com.ulbs.deposit.controller;

import com.ulbs.deposit.converter.CladiriDto;
import com.ulbs.deposit.entity.Cladiri;
import com.ulbs.deposit.entity.Echipament;
import com.ulbs.deposit.service.ICladiriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class CladiriController {
    @Autowired
    ICladiriService cladiriService;

    @GetMapping(path = "/Cladiri")
    public String getCladiri(Model model){
        List<Cladiri> cladiri = cladiriService.getAllCladiri();
        model.addAttribute("ListaCladiri", cladiri);
        return "Cladiri";
    }

    @GetMapping("/AddNewCladire")
    public String showAddCladireForm() {
        return "addNewCladire";
    }

    @PostMapping(path = "/AddNewCladire", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewCladire(CladiriDto cladiridto, Model model){
        Cladiri cladiri = new Cladiri();
        cladiri.setNumeCladire(cladiridto.getNumeCladire());
        cladiri.setNrmaxEtaje(cladiridto.getNrmaxEtaje());
        cladiriService.addNewCladire(cladiri);
        List<Cladiri> cladiriList = cladiriService.getAllCladiri();
        model.addAttribute("ListaCladiri", cladiriList);
        return "Cladiri";
    }

    @GetMapping("/DeleteCladire/{id}")
    public String deleteCladire(@PathVariable("id") Long id) {
        cladiriService.deleteCladire(id);
        return "redirect:/Cladiri";
    }

}
