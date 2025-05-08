package com.development.spring.invest_ai.InvestAI.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContoCorrenteDTO {

    private String numeroConto;
    private String iban;
    private BigDecimal saldo;
    private String valuta;
    private LocalDate dataApertura;
    private String stato;
    private String filiale;
}
