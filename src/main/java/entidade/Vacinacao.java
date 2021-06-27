/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonas
 */

@Entity
@Table(name = "vacinacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacinacao.findAll", query = "SELECT vn FROM Vacinacao vn"),
    @NamedQuery(name = "Vacinacao.findById", query = "SELECT vn FROM Vacinacao vn WHERE vn.id = :id"),
    @NamedQuery(name = "Vacinacao.findByLote", query = "SELECT vn FROM Vacinacao vn WHERE vn.lote = :lote"),
    @NamedQuery(name = "Vacinacao.findByDataVaciva", query = "SELECT vn FROM Vacinacao vn WHERE vn.dataVacina = :dataVacina")})
public class Vacinacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "lote")
    private String lote;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date dataVacina;
    
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente paciente;
    
    @JoinColumn(name = "vacina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vacina vacina;
    
    @JoinColumn(name = "enfermeiro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enfermeiro enfermeiro;
    

    public Vacinacao() {
    }
    
    public Vacinacao(Integer id) {
        this.id = id;
    }

    public Vacinacao(Integer id, String lote, Date dataVacina) {
        this.id = id;
        this.lote = lote;
        this.dataVacina = dataVacina;
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacinacao)) {
            return false;
        }
        Vacinacao other = (Vacinacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Vacinacao[ id=" + id + " ]";
    }
    
    
}
