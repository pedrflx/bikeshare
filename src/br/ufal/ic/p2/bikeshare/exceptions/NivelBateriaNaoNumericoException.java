package br.ufal.ic.p2.bikeshare.exceptions;

public class NivelBateriaNaoNumericoException extends BikeshareException
{
    public NivelBateriaNaoNumericoException()
    {
        super("Nivel de bateria deve ser numerico.");
    }
}
