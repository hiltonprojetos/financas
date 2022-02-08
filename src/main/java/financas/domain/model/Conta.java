/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import financas.domain.validation.ValidationGroups;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "CONTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByIConta", query = "SELECT c FROM Conta c WHERE c.iConta = :iConta"),
    @NamedQuery(name = "Conta.findByNomeConta", query = "SELECT c FROM Conta c WHERE c.nomeConta = :nomeConta"),
    @NamedQuery(name = "Conta.findBySaldoInicial", query = "SELECT c FROM Conta c WHERE c.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "Conta.findBySaldoAtual", query = "SELECT c FROM Conta c WHERE c.saldoAtual = :saldoAtual"),
    @NamedQuery(name = "Conta.findByAtivo", query = "SELECT c FROM Conta c WHERE c.ativo = :ativo")})
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
                
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(groups = ValidationGroups.ContaId.class)
    @Column(name = "I_CONTA")    
    private Integer iConta;
    @NotBlank
    @Basic(optional = false)
    @Column(name = "NOME_CONTA")
    private String nomeConta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @NotNull
    @Basic(optional = false)
    @Column(name = "SALDO_INICIAL")
    private BigDecimal saldoInicial;
    @NotNull
    @Basic(optional = false)
    @Column(name = "SALDO_ATUAL")
    private BigDecimal saldoAtual;
    @NotNull
    @Basic(optional = false)
    @Column(name = "ATIVO")
    private Boolean ativo;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iConta")
    private List<Despesa> despesaList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iConta")
    private List<Saldo> saldoList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iConta")
    private List<Receita> receitaList;

    public Conta() {
    }

    public Conta(Integer iConta) {
        this.iConta = iConta;
    }

    public Conta(Integer iConta, String nomeConta, BigDecimal saldoInicial, BigDecimal saldoAtual, Boolean ativo) {
        this.iConta = iConta;
        this.nomeConta = nomeConta;
        this.saldoInicial = saldoInicial;
        this.saldoAtual = saldoAtual;
        this.ativo = ativo;
    }

    public Integer getIConta() {
        return iConta;
    }

    public void setIConta(Integer iConta) {
        this.iConta = iConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
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
        hash += (iConta != null ? iConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.iConta == null && other.iConta != null) || (this.iConta != null && !this.iConta.equals(other.iConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Conta[ iConta=" + iConta + " ]";
    }
    
}
