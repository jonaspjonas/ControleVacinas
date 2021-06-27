/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonas
 */

@Entity
@Table(name = "enfermeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermeiro.findAll", query = "SELECT e FROM Enfermeiro e"),
    @NamedQuery(name = "Enfermeiro.findById", query = "SELECT e FROM Enfermeiro e WHERE e.id = :id"),
    @NamedQuery(name = "Enfermeiro.findByTelefone", query = "SELECT e FROM Enfermeiro e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Enfermeiro.findByNome", query = "SELECT e FROM Enfermeiro e WHERE e.nome = :nome")})
public class Enfermeiro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "telefone")
    private String telefone;
    

    public Enfermeiro() {
    }

   public Enfermeiro(Integer id) {
        this.id = id;
    }

    public Enfermeiro(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if (!(object instanceof Enfermeiro)) {
            return false;
        }
        Enfermeiro other = (Enfermeiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Enfermeiro[ id=" + id + " ]";
    }
    
    
    
}
