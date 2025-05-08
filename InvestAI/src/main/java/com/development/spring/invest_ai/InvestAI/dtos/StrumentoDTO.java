package com.development.spring.invest_ai.InvestAI.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StrumentoDTO {

    private String codiceIsin;
    private String nome;
    private String tipoStrumento;
    private String settore;
    private String areaGeografica;
    private String valuta;
    private BigDecimal prezzoCorrente;
    private LocalDateTime ultimoAggiornamentoPrezzo;
}
