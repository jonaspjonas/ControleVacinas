/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import dao.GenericDAO;
import entidade.Paciente;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class PacienteRN {

    private final GenericDAO<Paciente> PACIENTE_DAO = new GenericDAO<>();

    public boolean salvar(Paciente paciente) {
        if (paciente == null) {
            return false;
        } else {
            if (paciente.getId() == null || paciente.getId() == null) {
                return PACIENTE_DAO.criar(paciente);
            } else {
                return PACIENTE_DAO.alterar(paciente);
            }
        }
    }

    public List<Paciente> listar() {
        return PACIENTE_DAO.obterTodos(Paciente.class);
    }

    public Paciente obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return PACIENTE_DAO.obter(Paciente.class, id);
        }
    }

    public boolean excluir(Paciente paciente) {
        if (paciente == null) {
            return false;
        } else {
            return PACIENTE_DAO.excluir(paciente);
        }
    }
}
