package br.edu.fema.library.livro.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fema.library.livro.model.Livro;

public class LivroConnection {
	
	private Connection connection;
	
	public LivroConnection(Connection connection) {
		this.connection = connection;
	}
	
	 public List<Livro> getLivros() throws SQLException {
	        String sql = "SELECT * FROM LIVRO";
	        List<Livro> livros = new ArrayList<>();

	        try (PreparedStatement ps = connection.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Livro livro = new Livro();
	                livro.setCodigo(rs.getLong("codigo"));
	                livro.setTitulo(rs.getString("titulo"));
	                livro.setAutor(rs.getString("autor"));
	                livro.setDataLancamento(rs.getDate("data_lancamento"));
	                livro.setAlugado(rs.getBoolean("alugado"));
	                livro.setValidoAte(rs.getDate("valido_ate"));
	                livros.add(livro);
	            }
	        }

	        return livros;
	    }
	 
	 public List<Livro> getLivros(Long codigo) throws SQLException {
	        String sql = "SELECT * FROM LIVRO WHERE = " + codigo;
	        List<Livro> livros = new ArrayList<>();

	        try (PreparedStatement ps = connection.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Livro livro = new Livro();
	                livro.setCodigo(rs.getLong("codigo"));
	                livro.setTitulo(rs.getString("titulo"));
	                livro.setAutor(rs.getString("autor"));
	                livro.setDataLancamento(rs.getDate("data_lancamento"));
	                livro.setAlugado(rs.getBoolean("alugado"));
	                livro.setValidoAte(rs.getDate("valido_ate"));
	                livros.add(livro);
	            }
	        }

	        return livros;
	    }

}
