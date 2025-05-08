package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "risultato_simulazione")
public class RisultatoSimulazione extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "simulazione_id")
    private Simulazione simulazione;

    private LocalDateTime timestamp;
    private BigDecimal valoreProiettato;
    private double rendimentoAnnualizzato;
    private double volatilita;
    private double livelloConfidenza;
    private BigDecimal scenarioOttimistico;
    private BigDecimal scenarioPessimistico;
}
