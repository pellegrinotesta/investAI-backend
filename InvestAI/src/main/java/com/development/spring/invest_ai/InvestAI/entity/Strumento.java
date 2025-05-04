package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "strumento")
public class Strumento extends BasicEntity {

    private String codiceIsin;
    private String nome;
    private String tipoStrumento;
    private String settore;
    private String areaGeografica;
    private String valuta;
    private BigDecimal prezzoCorrente;
    private LocalDateTime ultimoAggiornamentoPrezzo;

    @OneToMany(mappedBy = "strumento")
    private List<Posizione> posizioni;

    @OneToMany(mappedBy = "strumento")
    private List<Transazione> transazioni;

    @OneToMany(mappedBy = "strumento")
    private List<DatiMercato> datiMercato;

    @OneToMany(mappedBy = "strumento")
    private List<Avviso> avvisi;
}
