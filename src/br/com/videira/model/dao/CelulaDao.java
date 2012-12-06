package br.com.videira.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.dto.CelulaDTO;

public class CelulaDao extends GenericDao {

    public CelulaDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(CelulaDTO celula) throws SQLException {
        String insert = "INSERT INTO tcelula(Titulo, DataInicio, DataMultiplicacao, PastorID, DiscipuladorID, LiderID, AnfitriaoID, DiaCelula) VALUES(?,?,?,?,?,?,?,?)";
        save(insert, celula.getTitulo(), celula.getDataInicio(), celula.getDataMultiplicacao(), celula.getPastorID(), celula.getDiscipuladorID(), celula.getLiderID(), celula.getAnfitriaoID(), celula.getDiaCelula());
    }

    public void alterar(CelulaDTO celula) throws SQLException {
        String update = "UPDATE tcelula " +
                "SET " +
                "Titulo = ?, " +
                "DataInicio = ?, " +
                "DataMultiplicacao = ?, " +
                "PastorID = ?, " +
                "DiscipuladorID = ?, " +
                "LiderID = ?, " +
                "AnfitriaoID = ?, " +
                "DiaCelula = ? " +
                "WHERE ID = ?";
        update(update, celula.getTitulo(), celula.getDataInicio(), celula.getDataMultiplicacao(), celula.getPastorID(), celula.getDiscipuladorID(), celula.getLiderID(), celula.getAnfitriaoID(), celula.getDiaCelula(), celula.getId());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM tcelula WHERE id = ?";
        delete(delete, id);
    }

    public List<CelulaDTO> findCelulas() throws SQLException {
        List<CelulaDTO> celulas = new ArrayList<CelulaDTO>();
        
        String select = "SELECT * FROM tcelula";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	CelulaDTO celula = new CelulaDTO();
        	celula.setId(rs.getInt("id"));
        	celula.setTitulo(rs.getString("Titulo"));
        	celula.setDataInicio(rs.getDate("DataInicio"));
        	celula.setDataMultiplicacao(rs.getDate("DataMultiplicacao"));
        	celula.setPastorID(rs.getInt("PastorID"));
        	celula.setDiscipuladorID(rs.getInt("DiscipuladorID"));
        	celula.setLiderID(rs.getInt("LiderID"));
        	celula.setAnfitriaoID(rs.getInt("AnfitriaoID"));
        	celula.setDiaCelula(rs.getString("DiaCelula"));
            
        	celulas.add(celula);
        }

        rs.close();
        stmt.close();

        return celulas;
    }

    public CelulaDTO findByTitulo(String titulo) throws SQLException {
        String select = "SELECT * FROM tcelula WHERE Titulo = ?";
        CelulaDTO celula = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	celula = new CelulaDTO();
        	celula.setId(rs.getInt("id"));
        	celula.setTitulo(rs.getString("Titulo"));
        	celula.setDataInicio(rs.getDate("DataInicio"));
        	celula.setDataMultiplicacao(rs.getDate("DataMultiplicacao"));
        	celula.setPastorID(rs.getInt("PastorID"));
        	celula.setDiscipuladorID(rs.getInt("DiscipuladorID"));
        	celula.setLiderID(rs.getInt("LiderID"));
        	celula.setAnfitriaoID(rs.getInt("AnfitriaoID"));
        	celula.setDiaCelula(rs.getString("DiaCelula"));
        }

        rs.close();
        stmt.close();
        return celula; 
    }
}
