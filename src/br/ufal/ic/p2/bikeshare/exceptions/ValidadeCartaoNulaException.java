package br.ufal.ic.p2.bikeshare.exceptions;

public class ValidadeCartaoNulaException extends BikeshareException
{

    public ValidadeCartaoNulaException()
    {
        super("Validade do cartao nao pode ser nula.");
    }
}
