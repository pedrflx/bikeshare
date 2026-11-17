package br.ufal.ic.p2.bikeshare.exceptions;

public class ValorNuloException extends BikeshareException
{

    public ValorNuloException()
    {
        super("Valor nao pode ser nulo.");
    }
}
