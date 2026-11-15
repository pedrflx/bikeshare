package br.ufal.ic.p2.bikeshare.exceptions;

public class MensalidadeNegativaException extends BikeshareException
{

    public MensalidadeNegativaException()
    {
        super("Mensalidade deve ser nao-negativa.");
    }
}
