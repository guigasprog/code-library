package br.edu.fema.library.biblioteca.model;

import br.edu.fema.library.setor.model.Setor;

import java.util.List;

public class Biblioteca {
    private Long codigo;
    private String nome;
    private String local;
    private List<Setor> setores;

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}
