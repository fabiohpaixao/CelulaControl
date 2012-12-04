package br.com.videira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.Frequencia;

public class FrequenciaDao extends GenericDao {

    public FrequenciaDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(Frequencia frequencia) throws SQLException {
        String insert = "INSERT INTO tfrequencia(MembroID, Evento, Data, Presente) VALUES(?,?,?,?)";
        save(insert, frequencia.getMembroID(), frequencia.getEvento(), frequencia.getData(), frequencia.getPresente());
    }

    public void alterar(Frequencia frequencia) throws SQLException {
        String update = "UPDATE tfrequencia " +
                "SET " +
                "MembroID = ?, " +
                "Evento = ?, " +
                "Data = ?, " +
                "Presente = ? " +
                "WHERE ID = ?";
        update(update, frequencia.getMembroID(), frequencia.getEvento(), frequencia.getData(), frequencia.getPresente(), frequencia.getId());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM tfrequencia WHERE ID = ?";
        delete(delete, id);
    }

    public List<Frequencia> findFrequencias() throws SQLException {
        List<Frequencia> frequencias = new ArrayList<Frequencia>();
        
        String select = "SELECT * FROM tfrequencia";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	
        	Frequencia frequencia = new Frequencia();
        	frequencia.setId(rs.getInt("ID"));
        	frequencia.setMembroID(rs.getInt("MembroID"));
        	frequencia.setEvento(rs.getString("Evento"));
        	frequencia.setData(rs.getDate("Data"));
        	frequencia.setPresente(rs.getInt("Presente"));
        	
        	frequencias.add(frequencia);
        }

        rs.close();
        stmt.close();

        return frequencias;
    }

    public Frequencia findByMembro(Integer membroID) throws SQLException {
        String select = "SELECT * FROM tfrequencia WHERE MembroID = ?";
        Frequencia frequencia = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setInt(1, membroID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	frequencia = new Frequencia();
        	frequencia.setId(rs.getInt("ID"));
        	frequencia.setMembroID(rs.getInt("MembroID"));
        	frequencia.setEvento(rs.getString("Evento"));
        	frequencia.setData(rs.getDate("Data"));
        	frequencia.setPresente(rs.getInt("Presente"));
        }

        rs.close();
        stmt.close();
        return frequencia; 
    }
}
