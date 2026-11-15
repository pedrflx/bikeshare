package br.ufal.ic.p2.bikeshare.exceptions;

public class MensalidadeNulaException extends BikeshareException
{

    public MensalidadeNulaException()
    {
        super("Mensalidade nao pode ser nula.");
    }
}
