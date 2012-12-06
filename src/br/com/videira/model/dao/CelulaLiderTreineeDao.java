package br.com.videira.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.dto.CelulaLiderTreineeDTO;

public class CelulaLiderTreineeDao extends GenericDao {

    public CelulaLiderTreineeDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(CelulaLiderTreineeDTO celulaLiderTreinee) throws SQLException {
        String insert = "INSERT INTO tcelulaLiderTreinee(CelulaID, MembroID) VALUES(?,?)";
        save(insert, celulaLiderTreinee.getCelulaID(), celulaLiderTreinee.getMembroID());
    }

    public void excluir(int membroID, int celulaID) throws SQLException {
        String delete = "DELETE FROM tcelulaLiderTreinee WHERE MembroID = ? and CelulaID = ?";
        delete(delete, membroID, celulaID);
    }

    public List<CelulaLiderTreineeDTO> findLideresTreinee(int membroID) throws SQLException {
        List<CelulaLiderTreineeDTO> lideres = new ArrayList<CelulaLiderTreineeDTO>();
        
        String select = "SELECT * FROM tcelulaLiderTreinee WHERE CelulaID = ?";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setInt(1, membroID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	CelulaLiderTreineeDTO celulaLiderTreinee = new CelulaLiderTreineeDTO();
        	celulaLiderTreinee.setMembroID(rs.getInt("MembroID"));
        	celulaLiderTreinee.setCelulaID(rs.getInt("CelulaID"));
            
        	lideres.add(celulaLiderTreinee);
        }

        rs.close();
        stmt.close();

        return lideres;
    }
}
