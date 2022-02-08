/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.api.assembler;

import financas.api.controller.CategoriaController;
import financas.api.controller.CompetenciaController;
import financas.api.controller.ContaController;
import financas.api.controller.HomeController;
import financas.api.controller.SaldoController;
import financas.api.controller.TipoController;
import financas.api.controller.UsuarioController;
import financas.api.model.CategoriaDto;
import financas.api.model.CompetenciaDto;
import financas.api.model.ContaDto;
import financas.api.model.SaldoDto;
import financas.api.model.TipoDto;
import financas.api.model.UsuarioDto;
import financas.domain.model.Categoria;
import financas.domain.model.Competencia;
import financas.domain.model.Conta;
import financas.domain.model.Saldo;
import financas.domain.model.Tipo;
import financas.domain.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
//

/**
 *
 * @author Hilton
 */
@lombok.AllArgsConstructor
@Component
public class GenericAssembler {

    private final ModelMapper modelMapper;

    //Usuario Assembler
    public UsuarioDto toUsuarioModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDto.class)
                .add(linkTo(methodOn(UsuarioController.class).one(usuario.getIUsuario())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios"));
    }

    public CollectionModel<UsuarioDto> toUsuarioCollectionModel(List<Usuario> usuarios) {
        List<UsuarioDto> modelList = usuarios.stream().map(this::toUsuarioModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(UsuarioController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Usuario toUsuarioEntity(UsuarioDto usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    public List<Usuario> toUsuarioCollectionEntity(List<UsuarioDto> usuarioDto) {
        return usuarioDto.stream().map(this::toUsuarioEntity).collect(Collectors.toList());
    }
    
    //Categotia Assembler
    public CategoriaDto toCategoriaModel(Categoria entity) {
        return modelMapper.map(entity, CategoriaDto.class)
                .add(linkTo(methodOn(CategoriaController.class).one(entity.getICategoria())).withSelfRel(),
                linkTo(methodOn(CategoriaController.class).all()).withRel("categorias"));
    }

    public CollectionModel<CategoriaDto> toCategoriaCollectionModel(List<Categoria> entity) {
        List<CategoriaDto> modelList = entity.stream().map(this::toCategoriaModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(CategoriaController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Categoria toCategoriaEntity(CategoriaDto model) {
        return modelMapper.map(model, Categoria.class);
    }

    public List<Categoria> toCategoriaCollectionEntity(List<CategoriaDto> model) {
        return model.stream().map(this::toCategoriaEntity).collect(Collectors.toList());
    }
    
    //Tipo Assembler
     public TipoDto toTipoModel(Tipo entity) {
        return modelMapper.map(entity, TipoDto.class)
                .add(linkTo(methodOn(TipoController.class).one(entity.getITipo())).withSelfRel(),
                linkTo(methodOn(TipoController.class).all()).withRel("tipos"));
    }

    public CollectionModel<TipoDto> toTipoCollectionModel(List<Tipo> entity) {
        List<TipoDto> modelList = entity.stream().map(this::toTipoModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(TipoController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Tipo toTipoEntity(TipoDto model) {
        return modelMapper.map(model, Tipo.class);
    }

    public List<Tipo> toTipoCollectionEntity(List<TipoDto> model) {
        return model.stream().map(this::toTipoEntity).collect(Collectors.toList());
    }
    
    
    //Conta Assembler
    public ContaDto toContaModel(Conta entity) {
        return modelMapper.map(entity, ContaDto.class)
                .add(linkTo(methodOn(ContaController.class).one(entity.getIConta())).withSelfRel(),
                linkTo(methodOn(ContaController.class).all()).withRel("contas"));
    }

    public CollectionModel<ContaDto> toContaCollectionModel(List<Conta> entity) {
        List<ContaDto> modelList = entity.stream().map(this::toContaModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(ContaController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Conta toContaEntity(ContaDto model) {
        return modelMapper.map(model, Conta.class);
    }

    public List<Conta> toContaCollectionEntity(List<ContaDto> model) {
        return model.stream().map(this::toContaEntity).collect(Collectors.toList());
    }
    
    //Competencia Assembler
    public CompetenciaDto toCompetenciaModel(Competencia entity) {
        return modelMapper.map(entity, CompetenciaDto.class)
                .add(linkTo(methodOn(CompetenciaController.class).one(entity.getICompetencia())).withSelfRel(),
                linkTo(methodOn(CompetenciaController.class).all()).withRel("competencias"));
    }

    public CollectionModel<CompetenciaDto> toCompetenciaCollectionModel(List<Competencia> entity) {
        List<CompetenciaDto> modelList = entity.stream().map(this::toCompetenciaModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(CompetenciaController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Competencia toCompetenciaEntity(CompetenciaDto model) {
        return modelMapper.map(model, Competencia.class);
    }

    public List<Competencia> toCompetenciaCollectionEntity(List<CompetenciaDto> model) {
        return model.stream().map(this::toCompetenciaEntity).collect(Collectors.toList());
    }
    
    
    //Saldo Assembler
    public SaldoDto toSaldoModel(Saldo entity) {
        return modelMapper.map(entity, SaldoDto.class)
                .add(linkTo(methodOn(SaldoController.class).one(entity.getISaldo())).withSelfRel(),
                linkTo(methodOn(SaldoController.class).all()).withRel("saldos"));
    }

    public CollectionModel<SaldoDto> toSaldoCollectionModel(List<Saldo> entity) {
        List<SaldoDto> modelList = entity.stream().map(this::toSaldoModel).collect(Collectors.toList());
        return CollectionModel.of(modelList,
                linkTo(methodOn(SaldoController.class).all()).withSelfRel(),
                linkTo(methodOn(HomeController.class).index()).withRel("root"));
    }

    public Saldo toSaldoEntity(SaldoDto model) {
        return modelMapper.map(model, Saldo.class);
    }

    public List<Saldo> toSaldoCollectionEntity(List<SaldoDto> model) {
        return model.stream().map(this::toSaldoEntity).collect(Collectors.toList());
    }
}
