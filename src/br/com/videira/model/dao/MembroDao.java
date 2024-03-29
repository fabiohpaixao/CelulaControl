package br.com.videira.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.videira.model.dto.MembroDTO;

public class MembroDao extends GenericDao {

    public MembroDao() throws InstantiationException,
			IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salvar(MembroDTO membro) throws SQLException {
        String insert = "INSERT INTO tmembro(Nome, TelResidencial, TelComercial, TelCelular1, TelCelular2," +
        		" Email, DataNascimento, FuncaoID, Encontro, Batismo, Cursao, CTL, Consolidado, ConsolidadorID, DataSaida, MotivoSaida, CEP, Rua, Bairro, Cidade, Estado, Numero) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        save(insert, membro.getNome(), membro.getTelefoneRes(), membro.getTelefoneCom(), membro.getTelefoneCel1(), membro.getTelefoneCel2(),
        		membro.getEmail(), membro.getDataNascimento(), membro.getFuncaoID(), membro.getEncontro(), membro.getBatismo(), membro.getCursao(), 
        		membro.getCtl(), membro.getConsolidacao(), membro.getConsolidadorID(), membro.getDataSaida(), membro.getMotivoSaida(),
        		membro.getCep(), membro.getRua(), membro.getBairro(), membro.getCidade(), membro.getEstado(), membro.getNumero());
    }

    public void alterar(MembroDTO membro) throws SQLException {
        String update = "UPDATE tmembro " +
                "SET " +
                "Nome = ?, " +
                "TelResidencial = ?, " +
                "TelComercial = ?, " +
                "TelCelular1 = ?, " +
                "TelCelular2 = ?, " +
                "Email = ?, " +
                "DataNascimento = ?, " +
                "FuncaoID = ?, " +
                "Encontro = ?, " +
                "Batismo = ?, " +
                "Cursao = ?, " +
                "CTL = ?, " +
                "Consolidado = ?, " +
                "ConsolidadorID = ?, " +
                "DataSaida = ?, " +
                "MotivoSaida = ? " +
                "CEP = ? " +
                "Rua = ? " +
                "Bairro = ? " +
                "Cidade = ? " +
                "Estado = ? " +
                "Numero = ? " +
                "WHERE ID = ?";
        update(update, membro.getNome(), membro.getTelefoneRes(), membro.getTelefoneCom(), membro.getTelefoneCel1(), membro.getTelefoneCel2(),
        		membro.getEmail(), membro.getDataNascimento(), membro.getFuncaoID(), membro.getEncontro(), membro.getBatismo(), membro.getCursao(), 
        		membro.getCtl(), membro.getConsolidacao(), membro.getConsolidadorID(), membro.getDataSaida(), membro.getMotivoSaida(), membro.getId(),
        		membro.getCep(), membro.getRua(), membro.getBairro(), membro.getCidade(), membro.getEstado(), membro.getNumero());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM tmembro WHERE ID = ?";
        delete(delete, id);
    }

    public List<MembroDTO> findMembros() throws SQLException {
        List<MembroDTO> membros = new ArrayList<MembroDTO>();
        
        String select = "SELECT * FROM tmembro";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
          
        	MembroDTO membro = new MembroDTO();
        	membro.setId(rs.getInt("ID"));
        	membro.setNome(rs.getString("Nome"));
        	membro.setTelefoneRes(rs.getString("TelResidencial"));
        	membro.setTelefoneCom(rs.getString("TelComercial"));
        	membro.setTelefoneCel1(rs.getString("TelCelular1"));
        	membro.setTelefoneCel2(rs.getString("TelCelular2"));
        	membro.setEmail(rs.getString("Email"));
        	membro.setDataNascimento(rs.getDate("DataNascimento"));
        	membro.setFuncaoID(rs.getInt("FuncaoID"));
        	membro.setEncontro(rs.getInt("Encontro"));
        	membro.setBatismo(rs.getInt("Batismo"));
        	membro.setCursao(rs.getInt("Cursao"));
        	membro.setCtl(rs.getInt("CTL"));
        	membro.setConsolidacao(rs.getInt("Consolidado"));
        	membro.setConsolidadorID(rs.getInt("ConsolidadorID"));
        	membro.setDataSaida(rs.getDate("DataSaida"));
        	membro.setMotivoSaida(rs.getString("MotivoSaida"));
        	membro.setCep(rs.getString("CEP"));
        	membro.setRua(rs.getString("Rua"));
        	membro.setBairro(rs.getString("Bairro"));
        	membro.setCidade(rs.getString("Cidade"));
        	membro.setEstado(rs.getString("Estado"));
        	membro.setNumero(rs.getInt("Numero"));
            
        	membros.add(membro);
        }

        rs.close();
        stmt.close();

        return membros;
    }

    public MembroDTO findByNome(String nome) throws SQLException {
        String select = "SELECT * FROM tmembro WHERE Nome = ?";
        MembroDTO membro = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	membro = new MembroDTO();
        	membro.setId(rs.getInt("ID"));
        	membro.setNome(rs.getString("Nome"));
        	membro.setTelefoneRes(rs.getString("TelResidencial"));
        	membro.setTelefoneCom(rs.getString("TelComercial"));
        	membro.setTelefoneCel1(rs.getString("TelCelular1"));
        	membro.setTelefoneCel2(rs.getString("TelCelular2"));
        	membro.setEmail(rs.getString("Email"));
        	membro.setDataNascimento(rs.getDate("DataNascimento"));
        	membro.setFuncaoID(rs.getInt("FuncaoID"));
        	membro.setEncontro(rs.getInt("Encontro"));
        	membro.setBatismo(rs.getInt("Batismo"));
        	membro.setCursao(rs.getInt("Cursao"));
        	membro.setCtl(rs.getInt("CTL"));
        	membro.setConsolidacao(rs.getInt("Consolidado"));
        	membro.setConsolidadorID(rs.getInt("ConsolidadorID"));
        	membro.setDataSaida(rs.getDate("DataSaida"));
        	membro.setMotivoSaida(rs.getString("MotivoSaida"));
        	membro.setCep(rs.getString("CEP"));
        	membro.setRua(rs.getString("Rua"));
        	membro.setBairro(rs.getString("Bairro"));
        	membro.setCidade(rs.getString("Cidade"));
        	membro.setEstado(rs.getString("Estado"));
        	membro.setNumero(rs.getInt("Numero"));
            
        }

        rs.close();
        stmt.close();
        return membro; 
    }

	public MembroDTO findByID(Integer ID) throws SQLException {
		String select = "SELECT * FROM tmembro WHERE ID = ?";
        MembroDTO membro = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setInt(1, ID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	membro = new MembroDTO();
        	membro.setId(rs.getInt("ID"));
        	membro.setNome(rs.getString("Nome"));
        	membro.setTelefoneRes(rs.getString("TelResidencial"));
        	membro.setTelefoneCom(rs.getString("TelComercial"));
        	membro.setTelefoneCel1(rs.getString("TelCelular1"));
        	membro.setTelefoneCel2(rs.getString("TelCelular2"));
        	membro.setEmail(rs.getString("Email"));
        	membro.setDataNascimento(rs.getDate("DataNascimento"));
        	membro.setFuncaoID(rs.getInt("FuncaoID"));
        	membro.setEncontro(rs.getInt("Encontro"));
        	membro.setBatismo(rs.getInt("Batismo"));
        	membro.setCursao(rs.getInt("Cursao"));
        	membro.setCtl(rs.getInt("CTL"));
        	membro.setConsolidacao(rs.getInt("Consolidado"));
        	membro.setConsolidadorID(rs.getInt("ConsolidadorID"));
        	membro.setDataSaida(rs.getDate("DataSaida"));
        	membro.setMotivoSaida(rs.getString("MotivoSaida"));
        	membro.setCep(rs.getString("CEP"));
        	membro.setRua(rs.getString("Rua"));
        	membro.setBairro(rs.getString("Bairro"));
        	membro.setCidade(rs.getString("Cidade"));
        	membro.setEstado(rs.getString("Estado"));
        	membro.setNumero(rs.getInt("Numero"));
            
        }

        rs.close();
        stmt.close();
        return membro; 
	}
}
