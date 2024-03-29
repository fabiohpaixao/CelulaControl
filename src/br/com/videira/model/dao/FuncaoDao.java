package br.com.videira.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.database.ConnectionDataBase;
import br.com.videira.model.dto.FuncaoDTO;

public class FuncaoDao extends GenericDao {
	
	 private Connection connection;

    public FuncaoDao() throws InstantiationException,
			IllegalAccessException {
		super();
		this.connection = ConnectionDataBase.getConnection();
		// TODO Auto-generated constructor stub
	}
    
    protected Connection getConnection() {
    	return connection;
    }

	public void salvar(FuncaoDTO funcao) throws SQLException {
        String insert = "INSERT INTO tfuncao(Titulo, Abreviacao) VALUES(?,?)";
        save(insert, funcao.getTitulo(), funcao.getAbreviacao());
    }

    public void alterar(FuncaoDTO funcao) throws SQLException {
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

    public List<FuncaoDTO> findFuncoes() throws SQLException {
     
    	List<FuncaoDTO> funcoes = new ArrayList<FuncaoDTO>();
        
        String select = "SELECT * FROM tfuncao";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	FuncaoDTO funcao = new FuncaoDTO();
        	funcao.setId(rs.getInt("id"));
        	funcao.setTitulo(rs.getString("Titulo"));
        	funcao.setAbreviacao(rs.getString("Abreviacao"));
            
        	funcoes.add(funcao);
        }

        rs.close();
        stmt.close();

        return funcoes;
    }

    public FuncaoDTO findByTitulo(String titulo) throws SQLException {
        String select = "SELECT * FROM tfuncao WHERE Titulo = ?";
        FuncaoDTO funcao = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	funcao = new FuncaoDTO();
        	funcao.setId(rs.getInt("id"));
        	funcao.setTitulo(rs.getString("Titulo"));
        	funcao.setAbreviacao(rs.getString("Abreviacao"));
        }

        rs.close();
        stmt.close();
        return funcao; 
    }
}
