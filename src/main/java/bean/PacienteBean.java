/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entidade.Paciente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import rn.PacienteRN;

/**
 *
 * @author Jonas
 */
@ManagedBean
@RequestScoped
public class PacienteBean {

    private List<Paciente> pacientes;
    private Paciente paciente = new Paciente();
    private final PacienteRN PACIENTE_RN = new PacienteRN();

    
    public PacienteBean() {
    }

    @PostConstruct
    public void init() {
        pacientes = PACIENTE_RN.listar();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void excluir() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (PACIENTE_RN.excluir(paciente)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Paciente excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            pacientes = PACIENTE_RN.listar();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o paciente");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void salvar() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (PACIENTE_RN.salvar(paciente)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Paciente salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o paciente");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

}
