package br.ufal.ic.p2.bikeshare.exceptions;

public class SaldoInsuficienteException extends BikeshareException
{

    public SaldoInsuficienteException()
    {
        super("Saldo insuficiente.");
    }
}
