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
@Table(name = "transazione")
public class Transazione extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "portafoglio_id")
    private Portafoglio portafoglio;

    @ManyToOne
    @JoinColumn(name = "strumento_id")
    private Strumento strumento;

    private String tipoTransazione;
    private double quantita;
    private BigDecimal prezzo;
    private BigDecimal importoTotale;
    private LocalDateTime dataTransazione;
    private String stato;
    private BigDecimal commissioni;
}
