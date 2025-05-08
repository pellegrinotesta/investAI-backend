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
public class ClienteDTO {

    private String codiceFiscale;
    private Date dataNascita;
    private String telefono;
    private String indirizzo;
    private String profiloRischio;
    private Date dataRegistrazione;
    private Date ultimoAccesso;
}
