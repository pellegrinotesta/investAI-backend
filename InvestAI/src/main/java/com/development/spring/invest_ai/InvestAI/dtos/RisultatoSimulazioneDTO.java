package com.development.spring.invest_ai.InvestAI.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RisultatoSimulazioneDTO {

    private LocalDateTime timestamp;
    private BigDecimal valoreProiettato;
    private double rendimentoAnnualizzato;
    private double volatilita;
    private double livelloConfidenza;
    private BigDecimal scenarioOttimistico;
    private BigDecimal scenarioPessimistico;
}
