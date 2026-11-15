package br.ufal.ic.p2.bikeshare.exceptions;

public class PlanoSemMensalidadeException extends BikeshareException
{

    public PlanoSemMensalidadeException()
    {
        super("Plano nao possui mensalidade.");
    }
}
