package br.ufal.ic.p2.bikeshare.sistema;

import java.io.Serializable;

/*
    "caixa" com tudo o que o sistema guarda entre uma execução e outra
*/

public class Dados implements Serializable {

    private RepositorioUsuarios usuarios;
    private RepositorioEstacoes estacoes;
    private RepositorioBicicletas bicicletas;

    public Dados()
    {
        this(new RepositorioUsuarios(), new RepositorioEstacoes(), new RepositorioBicicletas());
    }

    public Dados(RepositorioUsuarios usuarios, RepositorioEstacoes estacoes, RepositorioBicicletas bicicletas)
    {
        this.usuarios = usuarios;
        this.estacoes = estacoes;
        this.bicicletas = bicicletas;
    }

    public RepositorioUsuarios getUsuarios() {
        return usuarios;
    }

    public RepositorioEstacoes getEstacoes() {
        return estacoes;

    }

    public RepositorioBicicletas getBicicletas()
    {
        return bicicletas;
    }
}