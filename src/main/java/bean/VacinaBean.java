/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Vacina;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import rn.VacinaRN;

/**
 *
 * @author jonas
 */
@ManagedBean
@RequestScoped
public class VacinaBean {
    
    private List<Vacina> vacinas;
    private Vacina vacina = new Vacina();
    private final VacinaRN VACINA_RN = new VacinaRN();

    public VacinaBean() {
    }
    
    @PostConstruct
    public void init() {
        vacinas = VACINA_RN.listar();
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }


    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
    
    public void excluir() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (VACINA_RN.excluir(vacina)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Vacina excluída");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            vacinas = VACINA_RN.listar();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir a Vacina");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void salvar() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (VACINA_RN.salvar(vacina)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Vacina salva");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar a Vacina");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }
    
    
}
