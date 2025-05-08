package com.development.spring.invest_ai.InvestAI.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SimulazioneDTO {

    private String nome;
    private String descrizione;
    private LocalDateTime dataCreazione;
    private String tipoSimulazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private BigDecimal investimentoIniziale;
    private BigDecimal versamentoMensile;
    private int livelloRischio;
    private String stato;
}
