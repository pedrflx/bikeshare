package br.ufal.ic.p2.bikeshare.exceptions;

public class ChavePixNulaException extends BikeshareException
{

    public ChavePixNulaException()
    {
        super("Chave pix nao pode ser nula.");
    }
}
