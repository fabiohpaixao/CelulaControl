package br.com.videira.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.dto.MembroFuncaoDTO;

public class MembroFuncaoDao extends GenericDao {

    public MembroFuncaoDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(MembroFuncaoDTO membroFuncao) throws SQLException {
        String insert = "INSERT INTO tmembroFuncao(FuncaoID, MembroID) VALUES(?,?)";
        save(insert, membroFuncao.getFuncaoID(), membroFuncao.getMembroID());
    }

    public void excluir(int membroID, int funcaoID) throws SQLException {
        String delete = "DELETE FROM tmembroFuncao WHERE MembroID = ? and FuncaoID = ?";
        delete(delete, membroID, funcaoID);
    }

    public List<MembroFuncaoDTO> findAnfitrioes() throws SQLException {
        List<MembroFuncaoDTO> lideres = new ArrayList<MembroFuncaoDTO>();
        
        String select = "SELECT * FROM tmembroFuncao as mfunc INNER JOIN FuncaoAS func ON FuncaoID = mfunc.ID WHERE func.Titulo LIKE '%ntri%'";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	MembroFuncaoDTO membroFuncao = new MembroFuncaoDTO();
        	membroFuncao.setMembroID(rs.getInt("MembroID"));
        	membroFuncao.setFuncaoID(rs.getInt("FuncaoID"));
            
        	lideres.add(membroFuncao);
        }

        rs.close();
        stmt.close();

        return lideres;
    }
    
    public List<MembroFuncaoDTO> findLideres() throws SQLException {
    	List<MembroFuncaoDTO> lideres = new ArrayList<MembroFuncaoDTO>();
    	
    	String select = "SELECT * FROM tmembroFuncao as mfunc INNER JOIN FuncaoAS func ON FuncaoID = mfunc.ID WHERE func.Titulo LIKE '%der%'";
    	
    	PreparedStatement stmt = getConnection().prepareStatement(select);
    	ResultSet rs = stmt.executeQuery();
    	
    	while (rs.next()) {
    		
    		MembroFuncaoDTO membroFuncao = new MembroFuncaoDTO();
    		membroFuncao.setMembroID(rs.getInt("MembroID"));
    		membroFuncao.setFuncaoID(rs.getInt("FuncaoID"));
    		
    		lideres.add(membroFuncao);
    	}
    	
    	rs.close();
    	stmt.close();
    	
    	return lideres;
    }
    
    public List<MembroFuncaoDTO> findPastores() throws SQLException {
    	List<MembroFuncaoDTO> lideres = new ArrayList<MembroFuncaoDTO>();
    	
    	String select = "SELECT * FROM tmembroFuncao as mfunc INNER JOIN FuncaoAS func ON FuncaoID = mfunc.ID WHERE func.Titulo LIKE '%astor%'";
    	
    	PreparedStatement stmt = getConnection().prepareStatement(select);
    	ResultSet rs = stmt.executeQuery();
    	
    	while (rs.next()) {
    		
    		MembroFuncaoDTO membroFuncao = new MembroFuncaoDTO();
    		membroFuncao.setMembroID(rs.getInt("MembroID"));
    		membroFuncao.setFuncaoID(rs.getInt("FuncaoID"));
    		
    		lideres.add(membroFuncao);
    	}
    	
    	rs.close();
    	stmt.close();
    	
    	return lideres;
    }
}
