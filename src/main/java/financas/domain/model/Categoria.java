/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import financas.domain.validation.ValidationGroups;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByICategoria", query = "SELECT c FROM Categoria c WHERE c.iCategoria = :iCategoria"),
    @NamedQuery(name = "Categoria.findByDescricao", query = "SELECT c FROM Categoria c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Categoria.findByClassificacao", query = "SELECT c FROM Categoria c WHERE c.classificacao = :classificacao"),
    @NamedQuery(name = "Categoria.findByAtivo", query = "SELECT c FROM Categoria c WHERE c.ativo = :ativo")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(groups = ValidationGroups.CategoriaId.class)
    @Column(name = "I_CATEGORIA")
    private Integer iCategoria;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CLASSIFICACAO")
    private Classificacao classificacao;
    @NotNull
    @Basic(optional = false)
    @Column(name = "ATIVO")
    private Boolean ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCategoria")
    private List<Despesa> despesaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCategoria")
    private List<Receita> receitaList;

    public Categoria() {
    }

    public Categoria(Integer iCategoria) {
        this.iCategoria = iCategoria;
    }

    public Categoria(Integer iCategoria, String descricao, Classificacao classificacao, Boolean ativo) {
        this.iCategoria = iCategoria;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.ativo = ativo;
    }

    public Integer getICategoria() {
        return iCategoria;
    }

    public void setICategoria(Integer iCategoria) {
        this.iCategoria = iCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

    @XmlTransient
    public List<Receita> getReceitaList() {
        return receitaList;
    }

    public void setReceitaList(List<Receita> receitaList) {
        this.receitaList = receitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iCategoria != null ? iCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.iCategoria == null && other.iCategoria != null) || (this.iCategoria != null && !this.iCategoria.equals(other.iCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Categoria[ iCategoria=" + iCategoria + " ]";
    }
    
}
