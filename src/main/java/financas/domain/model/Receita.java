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
@Table(name = "RECEITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r"),
    @NamedQuery(name = "Receita.findByIReceita", query = "SELECT r FROM Receita r WHERE r.iReceita = :iReceita"),
    @NamedQuery(name = "Receita.findByModo", query = "SELECT r FROM Receita r WHERE r.modo = :modo"),
    @NamedQuery(name = "Receita.findByQuantidadeParcelas", query = "SELECT r FROM Receita r WHERE r.quantidadeParcelas = :quantidadeParcelas"),
    @NamedQuery(name = "Receita.findByParcelaAtual", query = "SELECT r FROM Receita r WHERE r.parcelaAtual = :parcelaAtual"),
    @NamedQuery(name = "Receita.findByDescricao", query = "SELECT r FROM Receita r WHERE r.descricao = :descricao"),
    @NamedQuery(name = "Receita.findByValor", query = "SELECT r FROM Receita r WHERE r.valor = :valor"),
    @NamedQuery(name = "Receita.findByVencimento", query = "SELECT r FROM Receita r WHERE r.vencimento = :vencimento"),
    @NamedQuery(name = "Receita.findByRecebimento", query = "SELECT r FROM Receita r WHERE r.recebimento = :recebimento"),
    @NamedQuery(name = "Receita.findByRecebido", query = "SELECT r FROM Receita r WHERE r.recebido = :recebido"),
    @NamedQuery(name = "Receita.findBySimulado", query = "SELECT r FROM Receita r WHERE r.simulado = :simulado")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "I_RECEITA")
    private Integer iReceita;
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
    @Column(name = "RECEBIMENTO")
    @Temporal(TemporalType.DATE)
    private Date recebimento;
    @Basic(optional = false)
    @Column(name = "RECEBIDO")
    private Boolean recebido;
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

    public Receita() {
    }

    public Receita(Integer iReceita) {
        this.iReceita = iReceita;
    }

    public Receita(Integer iReceita, String modo, int quantidadeParcelas, int parcelaAtual, String descricao, BigDecimal valor, Date vencimento, Boolean recebido, Boolean simulado) {
        this.iReceita = iReceita;
        this.modo = modo;
        this.quantidadeParcelas = quantidadeParcelas;
        this.parcelaAtual = parcelaAtual;
        this.descricao = descricao;
        this.valor = valor;
        this.vencimento = vencimento;
        this.recebido = recebido;
        this.simulado = simulado;
    }

    public Integer getIReceita() {
        return iReceita;
    }

    public void setIReceita(Integer iReceita) {
        this.iReceita = iReceita;
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

    public Date getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(Date recebimento) {
        this.recebimento = recebimento;
    }

    public Boolean getRecebido() {
        return recebido;
    }

    public void setRecebido(Boolean recebido) {
        this.recebido = recebido;
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
        hash += (iReceita != null ? iReceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.iReceita == null && other.iReceita != null) || (this.iReceita != null && !this.iReceita.equals(other.iReceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financas.domain.model.Receita[ iReceita=" + iReceita + " ]";
    }
    
}
