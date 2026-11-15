package br.ufal.ic.p2.bikeshare.exceptions;

public class CpfNuloException extends BikeshareException
{

    public CpfNuloException()
    {
        super("CPF nao pode ser nulo.");
    }
}
