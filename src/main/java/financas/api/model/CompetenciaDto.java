/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import financas.domain.validation.ValidationGroups;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 *
 * @author Hilton
 */
@Relation(collectionRelation = "categoriass")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class CompetenciaDto extends RepresentationModel<CompetenciaDto> {

    private static final long serialVersionUID = 1L;
    @Valid
    @NotNull(groups = ValidationGroups.CompetenciaId.class)
    private Integer iCompetencia;
    @NotBlank
    private String descricao;    
    @NotBlank
    private String abreviacao;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataFim;
}
