package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "simulazione")
public class Simulazione extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

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

    @OneToMany(mappedBy = "simulazione")
    private List<RisultatoSimulazione> risultati;
}
