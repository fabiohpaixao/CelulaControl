package br.com.videira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.Funcao;

public class FuncaoDao extends GenericDao {

    public FuncaoDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(Funcao funcao) throws SQLException {
        String insert = "INSERT INTO tfuncao(Titulo, Abreviacao) VALUES(?,?)";
        save(insert, funcao.getTitulo(), funcao.getAbreviacao());
    }

    public void alterar(Funcao funcao) throws SQLException {
        String update = "UPDATE tfuncao " +
                "SET " +
                "Titulo = ?, " +
                "Abreviacao = ? " +
                "WHERE ID = ?";
        update(update, funcao.getTitulo(), funcao.getAbreviacao(), funcao.getId());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM tfuncao WHERE ID = ?";
        delete(delete, id);
    }

    public List<Funcao> findFuncoes() throws SQLException {
     
    	List<Funcao> funcoes = new ArrayList<Funcao>();
        
        String select = "SELECT * FROM tfuncao";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	Funcao funcao = new Funcao();
        	funcao.setId(rs.getInt("id"));
        	funcao.setTitulo(rs.getString("Titulo"));
        	funcao.setAbreviacao(rs.getString("Abreviacao"));
            
        	funcoes.add(funcao);
        }

        rs.close();
        stmt.close();

        return funcoes;
    }

    public Funcao findByTitulo(String titulo) throws SQLException {
        String select = "SELECT * FROM tfuncao WHERE Titulo = ?";
        Funcao funcao = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	funcao = new Funcao();
        	funcao.setId(rs.getInt("id"));
        	funcao.setTitulo(rs.getString("Titulo"));
        	funcao.setAbreviacao(rs.getString("Abreviacao"));
        }

        rs.close();
        stmt.close();
        return funcao; 
    }
}
