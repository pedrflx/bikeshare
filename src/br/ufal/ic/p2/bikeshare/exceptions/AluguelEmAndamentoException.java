package br.ufal.ic.p2.bikeshare.exceptions;

public class AluguelEmAndamentoException extends BikeshareException
{

    public AluguelEmAndamentoException()
    {
        super("Aluguel ainda esta em andamento.");
    }
}
