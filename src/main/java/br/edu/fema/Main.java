package br.edu.fema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import br.edu.fema.library.livro.connection.LivroConnection;
import br.edu.fema.library.livro.model.Livro;
import br.edu.fema.library.setor.connection.SetorConnection;
import br.edu.fema.library.setor.model.Setor;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            String driver = "org.h2.Driver";
            String url = "jdbc:h2:file:C:\\Users\\LABORINFO\\Documents\\banco\\banco";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, "sa", "password");

            LivroConnection livroConnection = new LivroConnection(connection);
            List<Livro> livros = livroConnection.getLivros();

            livros.forEach(livro -> {System.out.println(livro.getTitulo());});

            SetorConnection setorConnection = new SetorConnection(connection);
            List<Setor> setores = setorConnection.getSetor();

            livros.forEach(livro -> {System.out.println(livro.getTitulo());});
            setores.stream().forEach(setor -> setor.getLivros().stream().forEach(livro -> System.out.println(livro.getAutor())));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Conexão encerrada.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
