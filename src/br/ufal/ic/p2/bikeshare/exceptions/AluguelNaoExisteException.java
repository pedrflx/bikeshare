package br.ufal.ic.p2.bikeshare.exceptions;

public class AluguelNaoExisteException extends BikeshareException
{

    public AluguelNaoExisteException()
    {
        super("Aluguel nao existe.");
    }
}
