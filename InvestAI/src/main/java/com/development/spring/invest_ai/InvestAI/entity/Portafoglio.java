package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portafoglio")
public class Portafoglio extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String nome;
    private String descrizione;
    private LocalDateTime dataCreazione;
    private LocalDateTime ultimoAggiornamento;
    private BigDecimal valoreTotale;
    private double rendimentoYtd;
    private int livelloRischio;

    @OneToMany(mappedBy = "portafoglio")
    private List<Posizione> posizioni;

    @OneToMany(mappedBy = "portafoglio")
    private List<Transazione> transazioni;

    @OneToMany(mappedBy = "portafoglio")
    private List<Avviso> avvisi;
}
