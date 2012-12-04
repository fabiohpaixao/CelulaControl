package br.com.videira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.CelulaLiderTreinee;

public class CelulaLiderTreineeDao extends GenericDao {

    public CelulaLiderTreineeDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(CelulaLiderTreinee celulaLiderTreinee) throws SQLException {
        String insert = "INSERT INTO tcelulaLiderTreinee(CelulaID, MembroID) VALUES(?,?)";
        save(insert, celulaLiderTreinee.getCelulaID(), celulaLiderTreinee.getMembroID());
    }

    public void excluir(int membroID, int celulaID) throws SQLException {
        String delete = "DELETE FROM tcelulaLiderTreinee WHERE MembroID = ? and CelulaID = ?";
        delete(delete, membroID, celulaID);
    }

    public List<CelulaLiderTreinee> findLideresTreinee(int membroID) throws SQLException {
        List<CelulaLiderTreinee> lideres = new ArrayList<CelulaLiderTreinee>();
        
        String select = "SELECT * FROM tcelulaLiderTreinee WHERE CelulaID = ?";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setInt(1, membroID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	CelulaLiderTreinee celulaLiderTreinee = new CelulaLiderTreinee();
        	celulaLiderTreinee.setMembroID(rs.getInt("MembroID"));
        	celulaLiderTreinee.setCelulaID(rs.getInt("CelulaID"));
            
        	lideres.add(celulaLiderTreinee);
        }

        rs.close();
        stmt.close();

        return lideres;
    }
}
