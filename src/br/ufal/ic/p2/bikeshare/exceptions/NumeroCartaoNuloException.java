package br.ufal.ic.p2.bikeshare.exceptions;

public class NumeroCartaoNuloException extends BikeshareException
{

    public NumeroCartaoNuloException()
    {
        super("Numero do cartao nao pode ser nulo.");
    }
}
