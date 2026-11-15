package br.ufal.ic.p2.bikeshare.exceptions;

public class NomeNuloException extends BikeshareException
{

    public NomeNuloException()
    {
        super("Nome nao pode ser nulo.");
    }
}
