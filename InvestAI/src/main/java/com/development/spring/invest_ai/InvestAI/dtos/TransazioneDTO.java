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
public class TransazioneDTO {

    private String tipoTransazione;
    private double quantita;
    private BigDecimal prezzo;
    private BigDecimal importoTotale;
    private LocalDateTime dataTransazione;
    private String stato;
    private BigDecimal commissioni;
}
