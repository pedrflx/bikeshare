package br.ufal.ic.p2.bikeshare.exceptions;

public class CapacidadeNaoNumericaException extends BikeshareException
{

    public CapacidadeNaoNumericaException()
    {
        super("Capacidade deve ser numerica.");
    }
}
