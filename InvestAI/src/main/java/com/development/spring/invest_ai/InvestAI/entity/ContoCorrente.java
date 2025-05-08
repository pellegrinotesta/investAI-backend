package com.development.spring.invest_ai.InvestAI.entity;

import com.development.spring.invest_ai.InvestAI.shared.entities.BasicEntity;
import jakarta.persistence.*;
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
@Table(name = "conto_corrente")
public class ContoCorrente extends BasicEntity {

    @Column(name ="numero_conto")
    private String numeroConto;

    @Column(name="iban")
    private String iban;

    private BigDecimal saldo;
    private String valuta;
    private LocalDate dataApertura;
    private String stato;
    private String filiale;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
