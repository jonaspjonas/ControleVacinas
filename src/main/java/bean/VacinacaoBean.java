/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Enfermeiro;
import entidade.Paciente;
import entidade.Vacina;
import entidade.Vacinacao;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import rn.EnfermeiroRN;
import rn.PacienteRN;
import rn.VacinaRN;
import rn.VacinacaoRN;

/**
 *
 * @author jonas
 */
@ManagedBean
@RequestScoped
public class VacinacaoBean {
    
   private Paciente paciente = new Paciente();
   private Vacinacao vacinacao = new Vacinacao();
   private Enfermeiro enfermeiro = new Enfermeiro();
   private Vacina vacina = new Vacina();
   
   private final VacinacaoRN VACINACAO_RN = new VacinacaoRN();
   private final PacienteRN PACIENTE_RN = new PacienteRN();
   private final EnfermeiroRN ENFERMEIRO_RN = new EnfermeiroRN();
   private final VacinaRN VACINA_RN = new VacinaRN();
   
   public VacinacaoBean(){
       
   }
   
    
    
   
   @PostConstruct
    public void init() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        String pacienteID = currentInstance.getExternalContext().getRequestParameterMap().get("paciente");
        if (pacienteID != null) {
            try {
                int id = Integer.parseInt(pacienteID);
                paciente = PACIENTE_RN.obter(id);
                if (paciente == null) {
                    paciente = new Paciente();
                    enfermeiro = new Enfermeiro();
                    vacina = new Vacina();
                    FacesMessage fm = new FacesMessage("Aviso", "Não foi possível recuperar o paciente. Código inválido.");
                    fm.setSeverity(FacesMessage.SEVERITY_WARN);
                    currentInstance.addMessage(null, fm);
                }
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage("Erro", "Não foi possível recuperar o paciente");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
                paciente = new Paciente();
            }
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Vacinacao getVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(Vacinacao vacinacao) {
        this.vacinacao = vacinacao;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
    
    

    
    
    public void adicionar() {
        if (vacinacao != null) {
            vacinacao.setPaciente(paciente);
            FacesContext currentInstance = FacesContext.getCurrentInstance();
            if (VACINACAO_RN.salvar(vacinacao)) {
                FacesMessage fm = new FacesMessage("Sucesso", "Vacina registrada");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                currentInstance.addMessage(null, fm);
                setPaciente(PACIENTE_RN.obter(paciente.getId())); //Atualizando o paciente
                vacinacao = new Vacinacao();
            } else {
                FacesMessage fm = new FacesMessage("Erro", "Não foi possível registrar a vacina");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
            }
        }
    }

    public void excluir() {
        if (vacinacao != null) {
            FacesContext currentInstance = FacesContext.getCurrentInstance();
            if (VACINACAO_RN.excluir(vacinacao)) {
                FacesMessage fm = new FacesMessage("Sucesso", "Vacina excluída");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                currentInstance.addMessage(null, fm);
                setPaciente(PACIENTE_RN.obter(paciente.getId())); //Atualizando o paciente
                vacinacao = new Vacinacao();
            } else {
                FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir a vacina");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                currentInstance.addMessage(null, fm);
            }
        }
    }
}
