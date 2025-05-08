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
public class DatiMercatoDTO {

    private StrumentoDTO strumento;
    private LocalDate data;
    private BigDecimal prezzoApertura;
    private BigDecimal prezzoMassimo;
    private BigDecimal prezzoMinimo;
    private BigDecimal prezzoChiusura;
    private Long volume;
    private BigDecimal prezzoChiusuraAggiustato;
}
