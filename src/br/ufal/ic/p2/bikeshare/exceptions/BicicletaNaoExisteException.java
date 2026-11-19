package br.ufal.ic.p2.bikeshare.exceptions;

public class BicicletaNaoExisteException extends BikeshareException
{
    public BicicletaNaoExisteException()
    {
        super("Bicicleta nao existe.");
    }
}
