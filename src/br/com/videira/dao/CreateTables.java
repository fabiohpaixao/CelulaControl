package br.com.videira.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    private Connection connection;
    

    public CreateTables() throws InstantiationException, IllegalAccessException {
        this.connection = ConnectionDataBase.getConnection();
    } 
    
    protected Connection getConnection() {
		return connection;
	}

    public void createTableCelula() {
        String sql = null;
        try {
        	
            sql = "CREATE TABLE tcelula (ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 2, INCREMENT BY 1), Titulo VARCHAR(250), DataInicio DATE, DataMultiplicacao DATE, PastorID INT, DiscipuladorID INT, LiderID INT, AnfitriaoID INT, DiaCelula VARCHAR, PRIMARY KEY (ID))";	
    		
            Statement stmt = getConnection().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Tabela Celula Ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableMembro() {
    	String sql = null;
    	try {
    		
    		sql = "CREATE TABLE tmenbro (ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 2, INCREMENT BY 1), Nome VARCHAR(250), TelResidencial VARCHAR(20), TelComercial VARCHAR(20), TelCelular1 VARCHAR(20), TelCelular2 VARCHAR(20), Email VARCHAR(150), DataNascimento DATE, FuncaoID INT, Encontro INT, Batismo INT, Cursao INT, CTL INT, Consolidado INT, Consolidador INT, DataSaida DATE, MotivoSaida VARCHAR(250), PRIMARY KEY (ID))";	
    		
    		Statement stmt = getConnection().createStatement();
    		stmt.executeUpdate(sql);
    		stmt.close();
    		System.out.println("Tabela Membro Ok!");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void createTableFuncao() {
    	String sql = null;
    	try {
    		
    		sql = "CREATE TABLE tfuncao (ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 2, INCREMENT BY 1), Titulo VARCHAR(250), Abreviacao VARCHAR(10), PRIMARY KEY (ID))";	
    		
    		Statement stmt = getConnection().createStatement();
    		stmt.executeUpdate(sql);
    		stmt.close();
    		System.out.println("Tabela Funcao Ok!");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void createTableCelulaLiderTreinee() {
    	String sql = null;
    	try {
    		
    		sql = "CREATE TABLE tcelulaLiderTreinee (CelulaID INT, MembroID INT, PRIMARY KEY (CelulaID, MembroID))";	
    		
    		Statement stmt = getConnection().createStatement();
    		stmt.executeUpdate(sql);
    		stmt.close();
    		System.out.println("Tabela CelulaLiderTreinee Ok!");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void createTableFrequencia() {
    	String sql = null;
    	try {
    		
    		sql = "CREATE TABLE tfrequencia (ID INT, MembroID INT, Evento VARCHAR(50), Data DATE, Presente INT, PRIMARY KEY (ID))";	
    		
    		Statement stmt = getConnection().createStatement();
    		stmt.executeUpdate(sql);
    		stmt.close();
    		System.out.println("Tabela Frequencia Ok!");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }


}
