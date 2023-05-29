package com.ulbs.deposit.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private Long id;

    private String adresaEmail;

    public EmailDto(String adresaEmail) {
        this.adresaEmail = adresaEmail;

    }
}
