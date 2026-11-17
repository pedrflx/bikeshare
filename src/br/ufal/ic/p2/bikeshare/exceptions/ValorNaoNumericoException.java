package br.ufal.ic.p2.bikeshare.exceptions;

public class ValorNaoNumericoException extends BikeshareException
{

    public ValorNaoNumericoException()
    {
        super("Valor deve ser numerico.");
    }
}
