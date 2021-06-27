/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Enfermeiro;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import rn.EnfermeiroRN;

/**
 *
 * @author jonas
 */

@ManagedBean
@RequestScoped
public class EnfermeiroBean {
    
    private List<Enfermeiro> enfermeiros;
    private Enfermeiro enfermeiro = new Enfermeiro();
    private final EnfermeiroRN ENFERMEIRO_RN = new EnfermeiroRN();

    public EnfermeiroBean() {
    }
    
    @PostConstruct
    public void init() {
        enfermeiros = ENFERMEIRO_RN.listar();
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
    
    
    
}
