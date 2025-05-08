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
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dati_mercato")
public class DatiMercato extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "strumento_id")
    private Strumento strumento;

    private LocalDate data;
    private BigDecimal prezzoApertura;
    private BigDecimal prezzoMassimo;
    private BigDecimal prezzoMinimo;
    private BigDecimal prezzoChiusura;
    private Long volume;
    private BigDecimal prezzoChiusuraAggiustato;
}
