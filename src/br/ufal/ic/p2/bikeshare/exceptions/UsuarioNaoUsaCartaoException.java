package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoUsaCartaoException extends BikeshareException
{

    public UsuarioNaoUsaCartaoException()
    {
        super("Usuario nao usa cartao.");
    }
}