package br.edu.fema.library.setor.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fema.library.biblioteca.model.Biblioteca;
import br.edu.fema.library.livro.connection.LivroConnection;
import br.edu.fema.library.livro.model.Livro;
import br.edu.fema.library.setor.model.Setor;

public class SetorConnection {

	private Connection connection;
	
	public SetorConnection(Connection connection) {
		this.connection = connection;
	}
	
	 public List<Setor> getSetor() throws SQLException {
	        String sql = "SELECT * FROM SETOR";
	        List<Setor> setores = new ArrayList<>();

	        try (PreparedStatement ps = connection.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	            	Setor setor = new Setor();
	            	Biblioteca biblioteca = new Biblioteca();
	            	setor.setCodigo(rs.getLong("codigo"));
	            	setor.setNome(rs.getString("nome"));
	            	
	            	setor.setBiblioteca(biblioteca);
	            	LivroConnection livroConnection = new LivroConnection(connection);
	            	setor.setLivros(livroConnection.getLivros(rs.getLong("codigo")));
	                setores.add(setor);
	            }
	        }

	        return setores;
	    }
	
	
}