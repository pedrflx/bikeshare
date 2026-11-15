package br.ufal.ic.p2.bikeshare.exceptions;

public class EmailNuloException extends BikeshareException
{

    public EmailNuloException()
    {
        super("Email nao pode ser nulo.");
    }
}
