package br.com.videira.model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.videira.model.dto.FuncaoDTO;

@SuppressWarnings("serial")
public class TableModelFuncoes  extends AbstractTableModel {

	 
    private List<FuncaoDTO> linhas;// Lista de Funcoes a serem exibidos na tabela
    private String[] colunas = new String[] { "ID", "Titulo", "Abrevia��o" }; // Array com os nomes das colunas.
    private static final int ID = 0;// Constantes representando o �ndice das colunas
    private static final int TITULO = 1;// Constantes representando o �ndice das colunas
    private static final int ABREVIACAO = 2;// Constantes representando o �ndice das colunas

    
    // Cria um FuncaoTableModel sem nenhuma linha
    public TableModelFuncoes() {
        linhas = new ArrayList<FuncaoDTO>();
    }
 
    // Cria um FuncaoTableModel contendo a lista recebida por par�metro
    public TableModelFuncoes(List<FuncaoDTO> listaDeFuncoes) {
        linhas = new ArrayList<FuncaoDTO>(listaDeFuncoes);
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
				case TITULO:
					return String.class;
				case ABREVIACAO:
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
		    FuncaoDTO funcao = linhas.get(rowIndex);
		 
		    switch (columnIndex) {
		    case ID:
		        return funcao.getId();
		    case TITULO:
		    	return funcao.getTitulo();
		    case ABREVIACAO:
		        return funcao.getAbreviacao();
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
	    	FuncaoDTO funcao = linhas.get(rowIndex);

	    	switch (columnIndex) {
	    	case ID:
	    		funcao.setId((int) aValue);
	    		break;
	    	case TITULO:
	    		funcao.setTitulo((String) aValue);
	    		break;
	    	case ABREVIACAO:
	    		funcao.setAbreviacao((String) aValue);
	    		break;
	    	default:
	    		// N�o deve ocorrer, pois s� existem 2 colunas
	    		throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    	}
	    	
	    	fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	    }
	    
	 // Retorna o s�cio referente a linha especificada
	    public FuncaoDTO getFuncao(int indiceLinha) {
	    	return linhas.get(indiceLinha);
	    }

	    // Adiciona o s�cio especificado ao modelo
	    public void addFuncao(FuncaoDTO funcao) {
	    	// Adiciona o registro.
	    	linhas.add(funcao);

	    	// Pega a quantidade de registros e subtrai 1 para
	    	// achar o �ltimo �ndice. A subtra��o � necess�ria
	    	// porque os �ndices come�am em zero.
	    	int ultimoIndice = getRowCount() - 1;

	    	// Notifica a mudan�a.
	    	fireTableRowsInserted(ultimoIndice, ultimoIndice);
	    }

	    // Remove o s�cio da linha especificada.
	    public void removeFuncao(int indiceLinha) {
	    	// Remove o registro.
	    	linhas.remove(indiceLinha);

	    	// Notifica a mudan�a.
	    	fireTableRowsDeleted(indiceLinha, indiceLinha);
	    }

	    // Adiciona uma lista de s�cios no final da lista.
	    public void addListaDeFuncaos(List<FuncaoDTO> funcaos) {
	    	// Pega o tamanho antigo da tabela, que servir�
	    	// como �ndice para o primeiro dos novos registros
	    	int indice = getRowCount();

	    	// Adiciona os registros.
	    	linhas.addAll(funcaos);

	    	// Notifica a mudan�a.
	    	fireTableRowsInserted(indice, indice + funcaos.size());
	    }

	    // Remove todos os registros.
	    public void limpar() {
	    	// Remove todos os elementos da lista de s�cios.
	    	linhas.clear();

	    	// Notifica a mudan�a.
	    	fireTableDataChanged();
	    }

	}
