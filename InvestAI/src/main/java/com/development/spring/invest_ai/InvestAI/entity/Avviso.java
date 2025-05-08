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
@Table(name = "avviso")
public class Avviso extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "strumento_id")
    private Strumento strumento;

    @ManyToOne
    @JoinColumn(name = "portafoglio_id")
    private Portafoglio portafoglio;

    private String tipoAvviso;
    private BigDecimal soglia;
    private String messaggio;
    private LocalDateTime dataCreazione;
    private LocalDateTime dataAttivazione;
    private String stato;
}
