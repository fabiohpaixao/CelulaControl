package br.com.videira.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.videira.dao.MembroDao;
import br.com.videira.model.Membro;

public class MembroController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String Nome, String TelResidencial, String TelComercial, String TelCelular1, String TelCelular2, 
    		String Email, Date DataNascimento, int FuncaoID, int Encontro, int Batismo, int Cursao,int CTL, int Consolidado, int ConsolidadorID, Date DataSaida, String MotivoSaida) throws SQLException, ParseException, InstantiationException, IllegalAccessException {
        Membro membro = new Membro();

    	membro.setNome(Nome);
    	membro.setTelefoneRes(TelResidencial);
    	membro.setTelefoneCom(TelComercial);
    	membro.setTelefoneCel1(TelCelular1);
    	membro.setTelefoneCel2(TelCelular2);
    	membro.setEmail(Email);
    	membro.setDataNascimento(formatarData(DataNascimento.toString()));
    	membro.setFuncaoID(FuncaoID);
    	membro.setEncontro(Encontro);
    	membro.setBatismo(Batismo);
    	membro.setCursao(Cursao);
    	membro.setCtl(CTL);
    	membro.setConsolidacao(Consolidado);
    	membro.setConsolidadorID(ConsolidadorID);
    	membro.setDataSaida(DataSaida);
    	membro.setMotivoSaida(MotivoSaida);

        new MembroDao().salvar(membro);
    }

    public void alterar(int ID, String Nome, String TelResidencial, String TelComercial, String TelCelular1, String TelCelular2, 
    		String Email, Date DataNascimento, int FuncaoID, int Encontro, int Batismo, int Cursao,int CTL, int Consolidado, int ConsolidadorID, Date DataSaida, String MotivoSaida) throws ParseException, SQLException, InstantiationException, IllegalAccessException {
        Membro membro = new Membro();
        membro.setId(ID);
        membro.setNome(Nome);
    	membro.setTelefoneRes(TelResidencial);
    	membro.setTelefoneCom(TelComercial);
    	membro.setTelefoneCel1(TelCelular1);
    	membro.setTelefoneCel2(TelCelular2);
    	membro.setEmail(Email);
    	membro.setDataNascimento(DataNascimento);
    	membro.setFuncaoID(FuncaoID);
    	membro.setEncontro(Encontro);
    	membro.setBatismo(Batismo);
    	membro.setCursao(Cursao);
    	membro.setCtl(CTL);
    	membro.setConsolidacao(Consolidado);
    	membro.setConsolidadorID(ConsolidadorID);
    	membro.setDataSaida(DataSaida);
    	membro.setMotivoSaida(MotivoSaida);

        new MembroDao().alterar(membro);
    }

    public List<Membro> listaMembros() throws InstantiationException, IllegalAccessException {
        MembroDao dao = new MembroDao();
        try {
            return dao.findMembros();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar membro\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int ID) throws SQLException, InstantiationException, IllegalAccessException {
        new MembroDao().excluir(ID);
    }

    public Membro buscaMembroPorNome(String Nome) throws SQLException, InstantiationException, IllegalAccessException {
        MembroDao dao = new MembroDao();
        return dao.findByNome(Nome);
    }
}
