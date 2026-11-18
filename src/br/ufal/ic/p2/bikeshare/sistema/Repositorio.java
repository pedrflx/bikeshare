package br.ufal.ic.p2.bikeshare.sistema;

import java.io.Serializable;

/*
    mãe de repositórios: gera os ids em sequência, com a letra de cada um (U1, U2...)
*/

public abstract class Repositorio implements Serializable
{

    private String prefixo;
    private int ultimoId = 0;

    public Repositorio(String prefixo)
    {
        this.prefixo = prefixo;
    }

    public String proximoId()
    {
        return prefixo + (ultimoId + 1);
    }

    protected void gastarId()
    {
        ultimoId++;
    }
}