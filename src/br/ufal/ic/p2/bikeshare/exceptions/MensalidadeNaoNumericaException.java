package br.ufal.ic.p2.bikeshare.exceptions;

public class MensalidadeNaoNumericaException extends BikeshareException
{

    public MensalidadeNaoNumericaException()
    {
        super("Mensalidade deve ser numerica.");
    }
}
