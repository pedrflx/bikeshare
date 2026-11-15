package br.ufal.ic.p2.bikeshare.exceptions;

public class IdentificacaoUsuarioNulaException extends BikeshareException
{

    public IdentificacaoUsuarioNulaException()
    {
        super("Identificacao do usuario nao pode ser nula.");
    }
}
