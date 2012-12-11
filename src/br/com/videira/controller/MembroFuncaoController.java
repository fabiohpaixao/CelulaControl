package br.com.videira.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.model.dao.MembroFuncaoDAO;
import br.com.videira.model.dto.MembroFuncaoDTO;

public class MembroFuncaoController {

    public void salvar(int funcaoID, int membroID) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        MembroFuncaoDTO funcaoLiderTreinee = new MembroFuncaoDTO();

    	funcaoLiderTreinee.setFuncaoID(funcaoID);
    	funcaoLiderTreinee.setMembroID(membroID);

        new MembroFuncaoDAO().salvar(funcaoLiderTreinee);
    }

    public List<MembroFuncaoDTO> listaFuncaoLiderTreinees(int membroID) throws InstantiationException, IllegalAccessException {
        MembroFuncaoDAO dao = new MembroFuncaoDAO();
        try {
            return dao.findLideresTreinee(membroID);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar funcaoLiderTreinee\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int membroID, int funcaoID) throws SQLException, InstantiationException, IllegalAccessException {
        new MembroFuncaoDAO().excluir(membroID, funcaoID);
    }

}
