package br.ufal.ic.p2.bikeshare.exceptions;

public class BicicletaJaExisteException extends BikeshareException
{
    public BicicletaJaExisteException()
    {
        super("Bicicleta ja existe.");
    }
}
