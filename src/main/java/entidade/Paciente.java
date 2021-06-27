/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonas
*/
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id"),
    @NamedQuery(name = "Paciente.findByNome", query = "SELECT p FROM Paciente p WHERE p.nome = :nome"),
    @NamedQuery(name = "Paciente.findByNascimento", query = "SELECT p FROM Paciente p WHERE p.nascimento = :nascimento"),
    @NamedQuery(name = "Paciente.findByTelefone", query = "SELECT p FROM Paciente p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Paciente.findBySus", query = "SELECT p FROM Paciente p WHERE p.sus = :sus")})
    public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "telefone")
    private String telefone;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sus")
    private String sus;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Vacinacao> vacinaList;
  

    public Paciente() {
    }
    
    public Paciente (Integer id) {
        this.id = id;
    }

    public Paciente(Integer id, String nome, Date nascimento, String telefone, String sus) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.sus = sus;
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }
    
    @XmlTransient
    public List<Vacinacao> getVacinaList() {
        return vacinaList;
    }

    public void setVacinaList(List<Vacinacao> vacinaList) {
        this.vacinaList = vacinaList;
    }
    
    
    
}
