package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.estacoes.Estacao;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.util.ArrayList;

/*
    guarda estações cadastradas, gera ids e procura por id
*/

public class RepositorioEstacoes extends Repositorio
{

    private ArrayList<Estacao> estacoes = new ArrayList<>();

    public RepositorioEstacoes()
    {
        super("E");
    }

    public String adicionar(Estacao nova)
    {
        estacoes.add(nova);
        gastarId();
        return nova.getId();
    }

    public Estacao buscar(String id) throws BikeshareException
    {
        Conversor.validarTexto(id, new IdentificacaoEstacaoNulaException());
        for (Estacao estacao : estacoes)
        {
            if (estacao.getId().equals(id))
            {
                return estacao;
            }
        }
        throw new EstacaoNaoExisteException();
    }
}