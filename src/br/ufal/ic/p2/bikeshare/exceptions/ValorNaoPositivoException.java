package br.ufal.ic.p2.bikeshare.exceptions;

public class ValorNaoPositivoException extends BikeshareException
{

    public ValorNaoPositivoException()
    {
        super("Valor deve ser positivo.");
    }
}
