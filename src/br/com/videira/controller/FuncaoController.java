package br.com.videira.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.dao.FuncaoDao;
import br.com.videira.model.Funcao;

public class FuncaoController {

    public void salvar(String Titulo, String Abreviacao) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        Funcao funcao = new Funcao();

    	funcao.setTitulo(Titulo);
    	funcao.setAbreviacao(Abreviacao);

        new FuncaoDao().salvar(funcao);
    }

    public void alterar(int ID, String Titulo, String Abreviacao) throws ParseException, SQLException, InstantiationException, IllegalAccessException {
        Funcao funcao = new Funcao();
        funcao.setId(ID);
        funcao.setTitulo(Titulo);
    	funcao.setAbreviacao(Abreviacao);
    	
        new FuncaoDao().alterar(funcao);
    }

    public List<Funcao> listaFuncaos() throws InstantiationException, IllegalAccessException {
        FuncaoDao dao = new FuncaoDao();
        try {
            return dao.findFuncoes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar funcao\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int ID) throws SQLException, InstantiationException, IllegalAccessException {
        new FuncaoDao().excluir(ID);
    }

    public Funcao buscaFuncaoPorNome(String Titulo) throws SQLException, InstantiationException, IllegalAccessException {
        FuncaoDao dao = new FuncaoDao();
        return dao.findByTitulo(Titulo);
    }
}
