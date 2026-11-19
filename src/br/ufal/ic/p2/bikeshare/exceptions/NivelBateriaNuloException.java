package br.ufal.ic.p2.bikeshare.exceptions;

public class NivelBateriaNuloException extends BikeshareException
{
    public NivelBateriaNuloException()
    {
        super("Nivel de bateria nao pode ser nulo.");
    }
}
