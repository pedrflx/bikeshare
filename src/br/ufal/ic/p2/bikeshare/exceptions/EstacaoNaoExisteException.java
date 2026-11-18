package br.ufal.ic.p2.bikeshare.exceptions;

public class EstacaoNaoExisteException extends BikeshareException
{

    public EstacaoNaoExisteException()
    {
        super("Estacao nao existe.");
    }
}
