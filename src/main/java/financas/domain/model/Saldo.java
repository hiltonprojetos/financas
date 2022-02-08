/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import financas.domain.validation.ValidationGroups;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "SALDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saldo.findAll", query = "SELECT s FROM Saldo s"),
    @NamedQuery(name = "Saldo.findByISaldo", query = "SELECT s FROM Saldo s WHERE s.iSaldo = :iSaldo"),
    @NamedQuery(name = "Saldo.findByValorPrevisto", query = "SELECT s FROM Saldo s WHERE s.valorPrevisto = :valorPrevisto"),
    @NamedQuery(name = "Saldo.findByValorAtual", query = "SELECT s FROM Saldo s WHERE s.valorAtual = :valorAtual"),
    @NamedQuery(name = "Saldo.findByEncerrado", query = "SELECT s FROM Saldo s WHERE s.encerrado = :encerrado")})
public class Saldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(groups = ValidationGroups.SaldoId.class)
    @Column(name = "I_SALDO")
    private Integer iSaldo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @NotNull
    @Basic(optional = false)
    @Column(name = "VALOR_PREVISTO")
    private BigDecimal valorPrevisto;
    @NotNull
    @Basic(optional = false)
    @Column(name = "VALOR_ATUAL")
    private BigDecimal valorAtual;
    @NotNull
    @Basic(optional = false)
    @Column(name = "ENCERRADO")
    private Boolean encerrado;
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.CompetenciaId.class)
    @NotNull
    @JoinColumn(name = "I_COMPETENCIA", referencedColumnName = "I_COMPETENCIA")
    @ManyToOne(optional = false)
    private Competencia iCompetencia;
    @Valid
    @ConvertGroup(from = Default.class,to = ValidationGroups.ContaId.class)
    @NotNull    
    @JoinColumn(name = "I_CONTA", referencedColumnName = "I_CONTA")
    @ManyToOne(optional = false)
    private Conta iConta;

    public Saldo() {
    }

    public Saldo(Integer iSaldo) {
        this.iSaldo = iSaldo;
    }

    public Saldo(Integer iSaldo, BigDecimal valorPrevisto, BigDecimal valorAtual, Boolean encerrado) {
        this.iSaldo = iSaldo;
        this.valorPrevisto = valorPrevisto;
        this.valorAtual = valorAtual;
        this.encerrado = encerrado;
    }

    public Integer getISaldo() {
        return iSaldo;
    }

    public void setISaldo(Integer iSaldo) {
        this.iSaldo = iSaldo;
    }

    public BigDecimal getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(BigDecimal valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Boolean getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(Boolean encerrado) {
        this.encerrado = encerrado;
    }

    public Competencia getICompetencia() {
        return iCompetencia;
    }

    public void setICompetencia(Competencia iCompetencia) {
        this.iCompetencia = iCompetencia;
    }

    public Conta getIConta() {
        return iConta;
    }

    public void setIConta(Conta iConta) {
        this.iConta = iConta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iSaldo != null ? iSaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saldo)) {
            return false;
        }
        Saldo other = (Saldo) object;
        if ((this.iSaldo == null && other.iSaldo != null) || (this.iSaldo != null && !this.iSaldo.equals(other.iSaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Saldo[ iSaldo=" + iSaldo + " ]";
    }
    
}
