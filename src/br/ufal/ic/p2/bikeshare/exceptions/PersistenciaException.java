package br.ufal.ic.p2.bikeshare.exceptions;

public class PersistenciaException extends BikeshareException
{

    public PersistenciaException()
    {
        super("Nao foi possivel salvar os dados do sistema.");
    }
}