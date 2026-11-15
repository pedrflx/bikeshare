package br.ufal.ic.p2.bikeshare.exceptions;

public class SenhaNulaException extends BikeshareException
{

    public SenhaNulaException()
    {
        super("Senha nao pode ser nula.");
    }
}
