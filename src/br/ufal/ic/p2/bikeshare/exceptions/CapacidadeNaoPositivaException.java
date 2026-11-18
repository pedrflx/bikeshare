package br.ufal.ic.p2.bikeshare.exceptions;

public class CapacidadeNaoPositivaException extends BikeshareException
{

    public CapacidadeNaoPositivaException()
    {
        super("Capacidade deve ser positiva.");
    }
}
