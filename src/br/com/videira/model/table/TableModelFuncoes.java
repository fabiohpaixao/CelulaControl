package br.com.videira.model.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.videira.model.Funcao;

@SuppressWarnings("serial")
public class TableModelFuncoes  extends AbstractTableModel {

	 
    private List<Funcao> linhas;// Lista de Funcoes a serem exibidos na tabela
    private String[] colunas = new String[] { "Titulo", "Abreviação" }; // Array com os nomes das colunas.
    private static final int NOME = 0;// Constantes representando o índice das colunas
    private static final int ENDERECO = 1;// Constantes representando o índice das colunas

    
    // Cria um FuncaoTableModel sem nenhuma linha
    public TableModelFuncoes() {
        linhas = new ArrayList<Funcao>();
    }
 
    // Cria um FuncaoTableModel contendo a lista recebida por parâmetro
    public TableModelFuncoes(List<Funcao> listaDeFuncoes) {
        linhas = new ArrayList<Funcao>(listaDeFuncoes);
    }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	};
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case NOME:
			return String.class;
		case ENDERECO:
			return String.class;
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o sócio referente a linha especificada.
	    Funcao funcao = linhas.get(rowIndex);
	 
	    switch (columnIndex) {
	    case NOME:
	        return funcao.getTitulo();
	    case ENDERECO:
	        return funcao.getAbreviacao();
	    default:
	        // Não deve ocorrer, pois só existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	    @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    	// Pega o sócio referente a linha especificada.
	    	Funcao funcao = linhas.get(rowIndex);

	    	switch (columnIndex) {
	    	case NOME:
	    		funcao.setTitulo((String) aValue);
	    		break;
	    	case ENDERECO:
	    		funcao.setAbreviacao((String) aValue);
	    		break;
	    	default:
	    		// Não deve ocorrer, pois só existem 2 colunas
	    		throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    	}
	    	
	    	fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	    }
	    
	 // Retorna o sócio referente a linha especificada
	    public Funcao getFuncao(int indiceLinha) {
	    	return linhas.get(indiceLinha);
	    }

	    // Adiciona o sócio especificado ao modelo
	    public void addFuncao(Funcao funcao) {
	    	// Adiciona o registro.
	    	linhas.add(funcao);

	    	// Pega a quantidade de registros e subtrai 1 para
	    	// achar o último índice. A subtração é necessária
	    	// porque os índices começam em zero.
	    	int ultimoIndice = getRowCount() - 1;

	    	// Notifica a mudança.
	    	fireTableRowsInserted(ultimoIndice, ultimoIndice);
	    }

	    // Remove o sócio da linha especificada.
	    public void removeFuncao(int indiceLinha) {
	    	// Remove o registro.
	    	linhas.remove(indiceLinha);

	    	// Notifica a mudança.
	    	fireTableRowsDeleted(indiceLinha, indiceLinha);
	    }

	    // Adiciona uma lista de sócios no final da lista.
	    public void addListaDeFuncaos(List<Funcao> funcaos) {
	    	// Pega o tamanho antigo da tabela, que servirá
	    	// como índice para o primeiro dos novos registros
	    	int indice = getRowCount();

	    	// Adiciona os registros.
	    	linhas.addAll(funcaos);

	    	// Notifica a mudança.
	    	fireTableRowsInserted(indice, indice + funcaos.size());
	    }

	    // Remove todos os registros.
	    public void limpar() {
	    	// Remove todos os elementos da lista de sócios.
	    	linhas.clear();

	    	// Notifica a mudança.
	    	fireTableDataChanged();
	    }

	}
