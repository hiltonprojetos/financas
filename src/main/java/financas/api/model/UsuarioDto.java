/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import financas.domain.model.Despesa;
import financas.domain.model.Receita;
import financas.domain.validation.ValidationGroups;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 *
 * @author Hilton
 */
@Relation(collectionRelation = "usuarios")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class UsuarioDto extends RepresentationModel<UsuarioDto> {

    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.UsuarioId.class)
    private Integer iUsuario;
    @Valid
    @NotBlank
    private String nlogin;
    @Valid
    @NotBlank
    private String nome;
    @Valid
    @NotBlank
    private String email;
    @Valid
    @NotNull
    private Boolean ativo;
    @Valid
    @NotBlank
    private String perfil;
    @JsonIgnore
    private List<Despesa> despesaList;
    @JsonIgnore
    private List<Receita> receitaList;
    

}
