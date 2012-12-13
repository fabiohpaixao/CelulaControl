package br.com.videira.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.model.dao.MembroFuncaoDao;
import br.com.videira.model.dto.MembroFuncaoDTO;

public class MembroFuncaoController {

    public void salvar(int funcaoID, int membroID) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        MembroFuncaoDTO membroFuncao = new MembroFuncaoDTO();

        membroFuncao.setFuncaoID(funcaoID);
        membroFuncao.setMembroID(membroID);

        new MembroFuncaoDao().salvar(membroFuncao);
    }

    public List<MembroFuncaoDTO> listaAnfitrioes() throws InstantiationException, IllegalAccessException {
    	MembroFuncaoDao dao = new MembroFuncaoDao();
        try {
            return dao.findAnfitrioes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar funcaoLiderTreinee\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int membroID, int funcaoID) throws SQLException, InstantiationException, IllegalAccessException {
        new MembroFuncaoDao().excluir(membroID, funcaoID);
    }

}
