/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import financas.domain.validation.ValidationGroups;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "COMPETENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c"),
    @NamedQuery(name = "Competencia.findByICompetencia", query = "SELECT c FROM Competencia c WHERE c.iCompetencia = :iCompetencia"),
    @NamedQuery(name = "Competencia.findByDescricao", query = "SELECT c FROM Competencia c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Competencia.findByAbreviacao", query = "SELECT c FROM Competencia c WHERE c.abreviacao = :abreviacao"),
    @NamedQuery(name = "Competencia.findByDataInicio", query = "SELECT c FROM Competencia c WHERE c.dataInicio = :dataInicio"),
    @NamedQuery(name = "Competencia.findByDataFim", query = "SELECT c FROM Competencia c WHERE c.dataFim = :dataFim")})
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @NotNull(groups = ValidationGroups.CompetenciaId.class)
    @Basic(optional = false)
    @Column(name = "I_COMPETENCIA")
    private Integer iCompetencia;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "ABREVIACAO")
    private String abreviacao;
    @NotNull
    @Basic(optional = false)
    @Column(name = "DATA_INICIO")
    private LocalDate dataInicio;
    @NotNull
    @Basic(optional = false)
    @Column(name = "DATA_FIM")
    private LocalDate dataFim;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCompetencia")
    private List<Despesa> despesaList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCompetencia")
    private List<Saldo> saldoList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCompetencia")
    private List<Receita> receitaList;

    public Competencia() {
    }

    public Competencia(Integer iCompetencia) {
        this.iCompetencia = iCompetencia;
    }

    public Competencia(Integer iCompetencia, String descricao, String abreviacao, LocalDate dataInicio, LocalDate dataFim) {
        this.iCompetencia = iCompetencia;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Integer getICompetencia() {
        return iCompetencia;
    }

    public void setICompetencia(Integer iCompetencia) {
        this.iCompetencia = iCompetencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @XmlTransient
    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

    @XmlTransient
    public List<Saldo> getSaldoList() {
        return saldoList;
    }

    public void setSaldoList(List<Saldo> saldoList) {
        this.saldoList = saldoList;
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
        hash += (iCompetencia != null ? iCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.iCompetencia == null && other.iCompetencia != null) || (this.iCompetencia != null && !this.iCompetencia.equals(other.iCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Competencia[ iCompetencia=" + iCompetencia + " ]";
    }
    
}
