package br.ufal.ic.p2.bikeshare.sistema;

import java.io.Serializable;

/*
    "caixa" com tudo o que o sistema guarda entre uma execução e outra
*/

public class Dados implements Serializable
{

    private RepositorioUsuarios usuarios;

    // sistema novo = nada cadastrado
    public Dados()
    {
        this(new RepositorioUsuarios());
    }

    public Dados(RepositorioUsuarios usuarios)
    {
        this.usuarios = usuarios;
    }

    public RepositorioUsuarios getUsuarios()
    {
        return usuarios;
    }
}