package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Email;

import java.util.List;

public interface IEmailService {
    List<Email> getAllEmails();

    void addNewEmail(Email email);

    void deleteEmail(Long id);
}
