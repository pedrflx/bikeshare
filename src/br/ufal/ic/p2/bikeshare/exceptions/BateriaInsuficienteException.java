package br.ufal.ic.p2.bikeshare.exceptions;

public class BateriaInsuficienteException extends BikeshareException
{

    public BateriaInsuficienteException()
    {
        super("Nivel de bateria insuficiente.");
    }
}
