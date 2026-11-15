package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoExisteException extends BikeshareException
{

    public UsuarioNaoExisteException()
    {
        super("Usuario nao existe.");
    }
}
