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
public class PosizioneDTO {

    private double quantita;
    private BigDecimal prezzoAcquisto;
    private LocalDateTime dataAcquisto;
    private BigDecimal valoreCorrente;
    private BigDecimal plusminusvalenza;
    private double plusminusvalenzaPercentuale;
}
