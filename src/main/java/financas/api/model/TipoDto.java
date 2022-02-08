/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import financas.domain.model.Classificacao;
import financas.domain.validation.ValidationGroups;
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
@Relation(collectionRelation = "tipos")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class TipoDto extends RepresentationModel<TipoDto> {

    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.TipoId.class)
    private Integer iTipo;
    @Valid
    @NotBlank
    private String descricao;
    @Valid
    @NotNull 
    private Classificacao classificacao;
    @Valid
    @NotNull
    private Boolean ativo;
    
    
}
