/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import dao.GenericDAO;
import entidade.Vacinacao;
import java.util.List;

/**
 *
 * @author jonas
 */
public class VacinacaoRN {
    
     private final GenericDAO<Vacinacao> VACINACAO_DAO = new GenericDAO<>();

    public boolean salvar(Vacinacao vacinacao) {
        if (vacinacao == null
                || vacinacao.getPaciente() == null) {
            return false;
        } else {
            if (vacinacao.getId() == null || vacinacao.getId() == 0) {
                return VACINACAO_DAO.criar(vacinacao);
            } else {
                return VACINACAO_DAO.alterar(vacinacao);
            }
        }
    }

    public List<Vacinacao> listar() {
        return VACINACAO_DAO.obterTodos(Vacinacao.class);
    }

    public Vacinacao obter(Integer id) {
        return VACINACAO_DAO.obter(Vacinacao.class, id);
    }

    public boolean excluir(Vacinacao vacinacao) {
        if (vacinacao == null) {
            return false;
        } else {
            return VACINACAO_DAO.excluir(vacinacao);
        }
    }
    
}
