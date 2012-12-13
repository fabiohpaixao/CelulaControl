package br.com.videira.model.table;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.videira.controller.MembroController;
import br.com.videira.model.dto.CelulaDTO;
import br.com.videira.model.dto.MembroDTO;

@SuppressWarnings("serial")
public class TableModelCelulas  extends AbstractTableModel {

	 
    private List<CelulaDTO> linhas;// Lista de Celulas a serem exibidos na tabela
    private String[] colunas = new String[] { "ID", "Titulo", "Abrevia��o" }; // Array com os nomes das colunas.
    private static final int ID = 0;// Constantes representando o �ndice das colunas
    private static final int NOME = 1;// Constantes representando o �ndice das colunas
    private static final int LIDER = 2;// Constantes representando o �ndice das colunas
    private static final int ANFITRIAO = 3;// Constantes representando o �ndice das colunas
    private static final int BAIRRO = 4;// Constantes representando o �ndice das colunas


    
    // Cria um CelulaTableModel sem nenhuma linha
    public TableModelCelulas() {
        linhas = new ArrayList<CelulaDTO>();
    }
 
    // Cria um CelulaTableModel contendo a lista recebida por par�metro
    public TableModelCelulas(List<CelulaDTO> listaDeCelulas) {
        linhas = new ArrayList<CelulaDTO>(listaDeCelulas);
    }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if(getRowCount() > columnIndex)
			return colunas[columnIndex];
		
		return null;
	};
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(getColumnCount() > columnIndex){
				switch (columnIndex) {
				case ID:
					return String.class;
				case NOME:
					return String.class;
				case LIDER:
					return String.class;
				case ANFITRIAO:
					return String.class;
				case BAIRRO:
					return String.class;
				default:
					// N�o deve ocorrer, pois s� existem 2 colunas
					throw new IndexOutOfBoundsException("columnIndex out of bounds");
				}
			}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o s�cio referente a linha especificada.
		if(getRowCount() > rowIndex && getColumnCount() > columnIndex){
		    CelulaDTO celula = linhas.get(rowIndex);
		    MembroController anfitriaoCtrl = new MembroController();
		    MembroDTO anfitriao = new MembroDTO();
		    try {
				anfitriao = anfitriaoCtrl.buscaMembroPorID(celula.getAnfitriaoID());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		    switch (columnIndex) {
		    case ID:
		        return celula.getId();
		    case NOME:
		    	return celula.getTitulo();
		    case LIDER:
		        return celula.getLiderID();
		    case ANFITRIAO:
		    	return anfitriao.getNome();
		    case BAIRRO:
		    	return anfitriao.getBairro();
		    default:
		        // N�o deve ocorrer, pois s� existem 2 colunas
		        throw new IndexOutOfBoundsException("columnIndex out of bounds");
		    }
		}
		return null;
	}
	    @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    	// Pega o s�cio referente a linha especificada.
	    	CelulaDTO celula = linhas.get(rowIndex);
	    	MembroController anfitriaoCtrl = new MembroController();
		    MembroDTO anfitriao = new MembroDTO();
		    try {
				anfitriao = anfitriaoCtrl.buscaMembroPorID(celula.getAnfitriaoID());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	switch (columnIndex) {
	    	case ID:
	    		celula.setId((int) aValue);
	    		break;
	    	case NOME:
	    		celula.setTitulo((String) aValue);
	    		break;
	    	case LIDER:
	    		celula.setLiderID((int) aValue);
	    		break;
	    	case ANFITRIAO:
	    		celula.setAnfitriaoID((int) aValue);
	    		break;
	    	case BAIRRO:
	    		anfitriao.setBairro((String) aValue);
	    		break;
	    	default:
	    		// N�o deve ocorrer, pois s� existem 2 colunas
	    		throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    	}
	    	
	    	fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	    }
	    
	 // Retorna o s�cio referente a linha especificada
	    public CelulaDTO getCelula(int indiceLinha) {
	    	return linhas.get(indiceLinha);
	    }

	    // Adiciona o s�cio especificado ao modelo
	    public void addCelula(CelulaDTO celula) {
	    	// Adiciona o registro.
	    	linhas.add(celula);

	    	// Pega a quantidade de registros e subtrai 1 para
	    	// achar o �ltimo �ndice. A subtra��o � necess�ria
	    	// porque os �ndices come�am em zero.
	    	int ultimoIndice = getRowCount() - 1;

	    	// Notifica a mudan�a.
	    	fireTableRowsInserted(ultimoIndice, ultimoIndice);
	    }

	    // Remove o s�cio da linha especificada.
	    public void removeCelula(int indiceLinha) {
	    	// Remove o registro.
	    	linhas.remove(indiceLinha);

	    	// Notifica a mudan�a.
	    	fireTableRowsDeleted(indiceLinha, indiceLinha);
	    }

	    // Adiciona uma lista de s�cios no final da lista.
	    public void addListaDeCelulas(List<CelulaDTO> celulas) {
	    	// Pega o tamanho antigo da tabela, que servir�
	    	// como �ndice para o primeiro dos novos registros
	    	int indice = getRowCount();

	    	// Adiciona os registros.
	    	linhas.addAll(celulas);

	    	// Notifica a mudan�a.
	    	fireTableRowsInserted(indice, indice + celulas.size());
	    }

	    // Remove todos os registros.
	    public void limpar() {
	    	// Remove todos os elementos da lista de s�cios.
	    	linhas.clear();

	    	// Notifica a mudan�a.
	    	fireTableDataChanged();
	    }

	}
