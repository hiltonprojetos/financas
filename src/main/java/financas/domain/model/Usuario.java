/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import financas.domain.validation.ValidationGroups;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "USUARIO",uniqueConstraints=
            @UniqueConstraint(columnNames={"NLOGIN", "EMAIL"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIUsuario", query = "SELECT u FROM Usuario u WHERE u.iUsuario = :iUsuario"),
    @NamedQuery(name = "Usuario.findByNlogin", query = "SELECT u FROM Usuario u WHERE u.nlogin = :nlogin"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo"),
    @NamedQuery(name = "Usuario.findByPerfil", query = "SELECT u FROM Usuario u WHERE u.perfil = :perfil")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(groups = ValidationGroups.UsuarioId.class)
    @Column(name = "I_USUARIO")
    private Integer iUsuario;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "NLOGIN")
    private String nlogin;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @NotBlank
    @Email
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Basic(optional = false)
    @NotBlank
    @Column(name = "PERFIL")
    private String perfil;

    public Usuario() {
    }

    public Usuario(Integer iUsuario) {
        this.iUsuario = iUsuario;
    }

    public Usuario(Integer iUsuario, String nlogin, String senha, String nome, Boolean ativo, String perfil) {
        this.iUsuario = iUsuario;
        this.nlogin = nlogin;
        this.senha = senha;
        this.nome = nome;
        this.ativo = ativo;
        this.perfil = perfil;
    }

    public Integer getIUsuario() {
        return iUsuario;
    }

    public void setIUsuario(Integer iUsuario) {
        this.iUsuario = iUsuario;
    }

    public String getNlogin() {
        return nlogin;
    }

    public void setNlogin(String nlogin) {
        this.nlogin = nlogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iUsuario != null ? iUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.iUsuario == null && other.iUsuario != null) || (this.iUsuario != null && !this.iUsuario.equals(other.iUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Usuario[ iUsuario=" + iUsuario + " ]";
    }
    
}
