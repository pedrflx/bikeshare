package br.ufal.ic.p2.bikeshare.exceptions;

public class IdentificacaoAluguelNulaException extends BikeshareException
{

    public IdentificacaoAluguelNulaException()
    {
        super("Identificacao do aluguel nao pode ser nula.");
    }
}
