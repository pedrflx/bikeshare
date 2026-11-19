package br.ufal.ic.p2.bikeshare.sistema;

import java.io.Serializable;

/*
    "caixa" com tudo o que o sistema guarda entre uma execução e outra
*/

public class Dados implements Serializable {

    private RepositorioUsuarios usuarios;
    private RepositorioEstacoes estacoes;

    public Dados() {
        this(new RepositorioUsuarios(), new RepositorioEstacoes());
    }

    public Dados(RepositorioUsuarios usuarios, RepositorioEstacoes estacoes)
    {
        this.usuarios = usuarios;
        this.estacoes = estacoes;
    }

    public RepositorioUsuarios getUsuarios() {
        return usuarios;
    }

    public RepositorioEstacoes getEstacoes() {
        return estacoes;

    }
}