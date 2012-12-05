package br.com.videira.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.dao.CelulaDao;
import br.com.videira.model.Celula;

public class CelulaController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String Titulo, Date DataInicio, Date DataMultiplicacao, int PastorID, int DiscipuladorID, int LiderID, int AnfitriaoID, String DiaCelula) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        Celula celula = new Celula();

    	celula.setTitulo(Titulo);
    	celula.setDataInicio(formatarData(DataInicio.toString()));
    	celula.setDataMultiplicacao(formatarData(DataMultiplicacao.toString()));
    	celula.setPastorID(PastorID);
    	celula.setDiscipuladorID(DiscipuladorID);
    	celula.setLiderID(LiderID);
    	celula.setAnfitriaoID(AnfitriaoID);
    	celula.setDiaCelula(DiaCelula);

        new CelulaDao().salvar(celula);
    }

    public void alterar(int ID, String Titulo, Date DataInicio, Date DataMultiplicacao, int PastorID, int DiscipuladorID, int LiderID, int AnfitriaoID, String DiaCelula) throws ParseException, SQLException, InstantiationException, IllegalAccessException {
        Celula celula = new Celula();
        celula.setId(ID);
        celula.setTitulo(Titulo);
    	celula.setDataInicio(formatarData(DataInicio.toString()));
    	celula.setDataMultiplicacao(formatarData(DataMultiplicacao.toString()));
    	celula.setPastorID(PastorID);
    	celula.setDiscipuladorID(DiscipuladorID);
    	celula.setLiderID(LiderID);
    	celula.setAnfitriaoID(AnfitriaoID);
    	celula.setDiaCelula(DiaCelula);

        new CelulaDao().alterar(celula);
    }

    public List<Celula> listaCelulas() throws InstantiationException, IllegalAccessException {
        CelulaDao dao = new CelulaDao();
        try {
            return dao.findCelulas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar celula\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int ID) throws SQLException, InstantiationException, IllegalAccessException {
        new CelulaDao().excluir(ID);
    }

    public Celula buscaCelulaPorNome(String Titulo) throws SQLException, InstantiationException, IllegalAccessException {
        CelulaDao dao = new CelulaDao();
        return dao.findByTitulo(Titulo);
    }
}
