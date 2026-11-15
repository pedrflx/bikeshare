package br.ufal.ic.p2.bikeshare.exceptions;

public class RazaoSocialNulaException extends BikeshareException
{

    public RazaoSocialNulaException()
    {
        super("Razao social nao pode ser nula.");
    }
}
