/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import financas.domain.validation.ValidationGroups;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hilton
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Getter
@lombok.Setter
public class CompetenciaResumo {
    @NotNull(groups = ValidationGroups.CompetenciaId.class)
    private Integer iCompetencia;
    private String abreviacao;
}
