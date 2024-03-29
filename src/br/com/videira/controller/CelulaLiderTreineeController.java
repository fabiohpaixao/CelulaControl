package br.com.videira.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.model.dao.CelulaLiderTreineeDao;
import br.com.videira.model.dto.CelulaLiderTreineeDTO;

public class CelulaLiderTreineeController {

    public void salvar(int celulaID, int membroID) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        CelulaLiderTreineeDTO celulaLiderTreinee = new CelulaLiderTreineeDTO();

    	celulaLiderTreinee.setCelulaID(celulaID);
    	celulaLiderTreinee.setMembroID(membroID);

        new CelulaLiderTreineeDao().salvar(celulaLiderTreinee);
    }

    public List<CelulaLiderTreineeDTO> listaCelulaLiderTreinees(int membroID) throws InstantiationException, IllegalAccessException {
        CelulaLiderTreineeDao dao = new CelulaLiderTreineeDao();
        try {
            return dao.findLideresTreinee(membroID);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar celulaLiderTreinee\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int membroID, int celulaID) throws SQLException, InstantiationException, IllegalAccessException {
        new CelulaLiderTreineeDao().excluir(membroID, celulaID);
    }

}
