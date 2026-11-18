package br.ufal.ic.p2.bikeshare.exceptions;

public class IdentificacaoEstacaoNulaException extends BikeshareException
{

    public IdentificacaoEstacaoNulaException()
    {
        super("Identificacao da estacao nao pode ser nula.");
    }
}
