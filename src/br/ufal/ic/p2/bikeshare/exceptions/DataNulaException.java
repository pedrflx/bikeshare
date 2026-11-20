package br.ufal.ic.p2.bikeshare.exceptions;

public class DataNulaException extends BikeshareException
{

    public DataNulaException()
    {
        super("Data nao pode ser nula.");
    }
}
