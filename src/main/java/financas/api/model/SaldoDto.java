/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import financas.domain.model.Competencia;
import financas.domain.model.Conta;
import financas.domain.validation.ValidationGroups;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 *
 * @author Hilton
 */
@Relation(collectionRelation = "saldos")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class SaldoDto extends RepresentationModel<SaldoDto> {

    private static final long serialVersionUID = 1L;

    @NotNull(groups = ValidationGroups.SaldoId.class)
    private Integer iSaldo;
    @NotNull
    private BigDecimal valorPrevisto;
    @NotNull
    private BigDecimal valorAtual;
    @NotNull
    private Boolean encerrado;
    @Valid
    @ConvertGroup(from = Default.class,to = ValidationGroups.CompetenciaId.class)
    @NotNull
    private CompetenciaResumo competencia;
    @Valid
    @ConvertGroup(from = Default.class,to = ValidationGroups.ContaId.class)
    @NotNull
    private ContaResumo iConta;
}
