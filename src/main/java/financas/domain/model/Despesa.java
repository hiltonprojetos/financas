/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financas.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hilton
 */
@Entity
@Table(name = "DESPESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d"),
    @NamedQuery(name = "Despesa.findByIDespesa", query = "SELECT d FROM Despesa d WHERE d.iDespesa = :iDespesa"),
    @NamedQuery(name = "Despesa.findByModo", query = "SELECT d FROM Despesa d WHERE d.modo = :modo"),
    @NamedQuery(name = "Despesa.findByQuantidadeParcelas", query = "SELECT d FROM Despesa d WHERE d.quantidadeParcelas = :quantidadeParcelas"),
    @NamedQuery(name = "Despesa.findByParcelaAtual", query = "SELECT d FROM Despesa d WHERE d.parcelaAtual = :parcelaAtual"),
    @NamedQuery(name = "Despesa.findByDescricao", query = "SELECT d FROM Despesa d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Despesa.findByValor", query = "SELECT d FROM Despesa d WHERE d.valor = :valor"),
    @NamedQuery(name = "Despesa.findByVencimento", query = "SELECT d FROM Despesa d WHERE d.vencimento = :vencimento"),
    @NamedQuery(name = "Despesa.findByPagamento", query = "SELECT d FROM Despesa d WHERE d.pagamento = :pagamento"),
    @NamedQuery(name = "Despesa.findByPago", query = "SELECT d FROM Despesa d WHERE d.pago = :pago"),
    @NamedQuery(name = "Despesa.findBySimulado", query = "SELECT d FROM Despesa d WHERE d.simulado = :simulado")})
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "I_DESPESA")
    private Integer iDespesa;
    @Basic(optional = false)
    @Column(name = "MODO")
    private String modo;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE_PARCELAS")
    private int quantidadeParcelas;
    @Basic(optional = false)
    @Column(name = "PARCELA_ATUAL")
    private int parcelaAtual;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Column(name = "PAGAMENTO")
    @Temporal(TemporalType.DATE)
    private Date pagamento;
    @Basic(optional = false)
    @Column(name = "PAGO")
    private Boolean pago;
    @Basic(optional = false)
    @Column(name = "SIMULADO")
    private Boolean simulado;
    @JoinColumn(name = "I_CATEGORIA", referencedColumnName = "I_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria iCategoria;
    @JoinColumn(name = "I_COMPETENCIA", referencedColumnName = "I_COMPETENCIA")
    @ManyToOne(optional = false)
    private Competencia iCompetencia;
    @JoinColumn(name = "I_CONTA", referencedColumnName = "I_CONTA")
    @ManyToOne(optional = false)
    private Conta iConta;
    @JoinColumn(name = "I_TIPO", referencedColumnName = "I_TIPO")
    @ManyToOne(optional = false)
    private Tipo iTipo;

    public Despesa() {
    }

    public Despesa(Integer iDespesa) {
        this.iDespesa = iDespesa;
    }

    public Despesa(Integer iDespesa, String modo, int quantidadeParcelas, int parcelaAtual, String descricao, BigDecimal valor, Date vencimento, Boolean pago, Boolean simulado) {
        this.iDespesa = iDespesa;
        this.modo = modo;
        this.quantidadeParcelas = quantidadeParcelas;
        this.parcelaAtual = parcelaAtual;
        this.descricao = descricao;
        this.valor = valor;
        this.vencimento = vencimento;
        this.pago = pago;
        this.simulado = simulado;
    }

    public Integer getIDespesa() {
        return iDespesa;
    }

    public void setIDespesa(Integer iDespesa) {
        this.iDespesa = iDespesa;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public int getParcelaAtual() {
        return parcelaAtual;
    }

    public void setParcelaAtual(int parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getSimulado() {
        return simulado;
    }

    public void setSimulado(Boolean simulado) {
        this.simulado = simulado;
    }

    public Categoria getICategoria() {
        return iCategoria;
    }

    public void setICategoria(Categoria iCategoria) {
        this.iCategoria = iCategoria;
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

    public Tipo getITipo() {
        return iTipo;
    }

    public void setITipo(Tipo iTipo) {
        this.iTipo = iTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDespesa != null ? iDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.iDespesa == null && other.iDespesa != null) || (this.iDespesa != null && !this.iDespesa.equals(other.iDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Despesa[ iDespesa=" + iDespesa + " ]";
    }
    
}
