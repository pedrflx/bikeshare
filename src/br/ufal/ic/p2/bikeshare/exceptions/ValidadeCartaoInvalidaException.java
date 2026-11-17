package br.ufal.ic.p2.bikeshare.exceptions;

public class ValidadeCartaoInvalidaException extends BikeshareException
{

    public ValidadeCartaoInvalidaException()
    {
        super("Validade do cartao invalida.");
    }
}
