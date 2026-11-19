package br.ufal.ic.p2.bikeshare.exceptions;

public class NivelBateriaForaDoLimiteException extends BikeshareException
{
    public NivelBateriaForaDoLimiteException()
    {
        super("Nivel de bateria deve estar entre 0 e 100.");
    }
}
