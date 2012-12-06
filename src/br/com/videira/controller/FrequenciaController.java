package br.com.videira.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.model.dao.FrequenciaDao;
import br.com.videira.model.dto.FrequenciaDTO;

public class FrequenciaController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(Integer MembroID, Date Data, String Evento, Integer Presente) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        FrequenciaDTO frequencia = new FrequenciaDTO();

     //   frequencia.setId(ID);
    	frequencia.setMembroID(MembroID);
    	frequencia.setEvento(Evento);
    	frequencia.setData(Data);
    	frequencia.setPresente(Presente);

        new FrequenciaDao().salvar(frequencia);
    }

    public void alterar(Integer ID, Integer MembroID, Date Data, String Evento, Integer Presente) throws ParseException, SQLException, InstantiationException, IllegalAccessException {
        FrequenciaDTO frequencia = new FrequenciaDTO();
        frequencia.setId(ID);
        frequencia.setMembroID(MembroID);
    	frequencia.setEvento(Evento);
    	frequencia.setData(Data);
    	frequencia.setPresente(Presente);

        new FrequenciaDao().alterar(frequencia);
    }

    public List<FrequenciaDTO> listaFrequencias() throws InstantiationException, IllegalAccessException {
        FrequenciaDao dao = new FrequenciaDao();
        try {
            return dao.findFrequencias();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar frequencia\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int ID) throws SQLException, InstantiationException, IllegalAccessException {
        new FrequenciaDao().excluir(ID);
    }

    public FrequenciaDTO buscaFrequenciaPorMembro(Integer membroID) throws SQLException, InstantiationException, IllegalAccessException {
        FrequenciaDao dao = new FrequenciaDao();
        return dao.findByMembro(membroID);
    }
}
