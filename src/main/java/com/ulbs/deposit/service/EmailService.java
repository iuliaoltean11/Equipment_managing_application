package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Email;
import com.ulbs.deposit.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    EmailRepository emailRepository;
    @Override
    public List<Email> getAllEmails() {
        return (List<Email>) emailRepository.findAll();
    }

    @Override
    public void addNewEmail(Email email) {
        emailRepository.save(email);
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
