/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonas
 */

@Entity
@Table(name = "vacina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v"),
    @NamedQuery(name = "Vacina.findById", query = "SELECT v FROM Vacina v WHERE v.id = :id"),
    @NamedQuery(name = "Vacina.findByNome", query = "SELECT v FROM Vacina v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vacina.findByFabricante", query = "SELECT v FROM Vacina v WHERE v.fabricante = :fabricante"),
    @NamedQuery(name = "Vacina.findByDescricao", query = "SELECT v FROM Vacina v WHERE v.descricao = :descricao")})
public class Vacina implements Serializable {
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
    @Size(min = 1, max = 100)
    private String fabricante;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String descricao;
    
    
    public Vacina() {
    }

    public Vacina(Integer id) {
        this.id = id;
    }

    public Vacina(Integer id, String nome, String fabricante, String descricao) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.descricao = descricao;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
