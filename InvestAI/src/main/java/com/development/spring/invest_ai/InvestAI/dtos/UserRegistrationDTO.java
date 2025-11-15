package com.development.spring.invest_ai.InvestAI.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserRegistrationDTO {

    private String password;
    private String email;
    private String name;
    private String surname;
    private String codiceFiscale;
    private Date dataNascita;
    private String telefono;
    private String indirizzo;

}
