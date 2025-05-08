package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente extends BasicEntity {

    @Column(name="codice_fiscale")
    private String codiceFiscale;

    @Column(name="data_nascita")
    private Date dataNascita;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "profilo_rischio")
    private String profiloRischio;

    @Column(name = "data_registrazione")
    private Date dataRegistrazione;

    @Column(name = "ultimo_accesso")
    private Date ultimoAccesso;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany(mappedBy = "cliente")
    private List<ContoCorrente> conti;

    @OneToMany(mappedBy = "cliente")
    private List<Portafoglio> portafogli;

    @OneToMany(mappedBy = "cliente")
    private List<Transazione> transazioni;

    @OneToMany(mappedBy = "cliente")
    private List<Simulazione> simulazioni;

    @OneToMany(mappedBy = "cliente")
    private List<Avviso> avvisi;


}
