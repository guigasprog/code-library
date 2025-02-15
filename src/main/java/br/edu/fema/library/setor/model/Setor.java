package br.edu.fema.library.setor.model;

import br.edu.fema.library.livro.model.Livro;

import java.util.List;

public class Setor {
    private Long codigo;
    private String nome;
    private List<Livro> livros;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
