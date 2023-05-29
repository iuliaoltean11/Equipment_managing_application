package com.ulbs.deposit.controller;

import com.ulbs.deposit.converter.CladiriDto;
import com.ulbs.deposit.converter.EchipamentDto;
import com.ulbs.deposit.converter.EmailDto;
import com.ulbs.deposit.entity.Cladiri;
import com.ulbs.deposit.entity.Email;
import com.ulbs.deposit.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;

    @GetMapping("/Email")
    public String emails(Model model) {
        List<Email> emailList = emailService.getAllEmails();
        model.addAttribute("ListaEmail", emailList);
        return "Email";
    }

    @GetMapping("/AddNewEmail")
    public String showAddEmailForm() {
        return "addNewEmail";
    }

    @PostMapping(path = "/AddNewEmail", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewEmail(EmailDto emaildto, Model model){
        Email email = new Email();
        email.setAdresaEmail(emaildto.getAdresaEmail());

        emailService.addNewEmail(email);
        return "redirect:/Email";
    }

    @GetMapping("/DeleteEmail/{id}")
    public String deleteCladire(@PathVariable("id") Long id) {
       emailService.deleteEmail(id);
        return "redirect:/Email";
    }


}
