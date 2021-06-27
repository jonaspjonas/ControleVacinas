/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import dao.GenericDAO;
import entidade.Enfermeiro;
import java.util.List;

/**
 *
 * @author jonas
 */
public class EnfermeiroRN {
    
    private final GenericDAO<Enfermeiro> ENFERMEIRO_DAO = new GenericDAO<>();

    public boolean salvar(Enfermeiro enfermeiro) {
        if (enfermeiro == null) {
            return false;
        } else {
            if (enfermeiro.getId() == null || enfermeiro.getId() == null) {
                return ENFERMEIRO_DAO.criar(enfermeiro);
            } else {
                return ENFERMEIRO_DAO.alterar(enfermeiro);
            }
        }
    }

    public List<Enfermeiro> listar() {
        return ENFERMEIRO_DAO.obterTodos(Enfermeiro.class);
    }

    public Enfermeiro obter(Integer id) {
        if (id == null) {
            return null;
        } else {
            return ENFERMEIRO_DAO.obter(Enfermeiro.class, id);
        }
    }

    public boolean excluir(Enfermeiro enfermeiro) {
        if (enfermeiro == null) {
            return false;
        } else {
            return ENFERMEIRO_DAO.excluir(enfermeiro);
        }
    }
    
}
