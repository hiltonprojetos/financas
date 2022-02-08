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
@Table(name = "TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByITipo", query = "SELECT t FROM Tipo t WHERE t.iTipo = :iTipo"),
    @NamedQuery(name = "Tipo.findByDescricao", query = "SELECT t FROM Tipo t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tipo.findByClassificacao", query = "SELECT t FROM Tipo t WHERE t.classificacao = :classificacao"),
    @NamedQuery(name = "Tipo.findByAtivo", query = "SELECT t FROM Tipo t WHERE t.ativo = :ativo")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(groups = ValidationGroups.TipoId.class)
    @Column(name = "I_TIPO")
    private Integer iTipo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTipo")
    private List<Despesa> despesaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTipo")
    private List<Receita> receitaList;

    public Tipo() {
    }

    public Tipo(Integer iTipo) {
        this.iTipo = iTipo;
    }

    public Tipo(Integer iTipo, String descricao, Classificacao classificacao, Boolean ativo) {
        this.iTipo = iTipo;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.ativo = ativo;
    }

    public Integer getITipo() {
        return iTipo;
    }

    public void setITipo(Integer iTipo) {
        this.iTipo = iTipo;
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
        hash += (iTipo != null ? iTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.iTipo == null && other.iTipo != null) || (this.iTipo != null && !this.iTipo.equals(other.iTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Tipo[ iTipo=" + iTipo + " ]";
    }
    
}
