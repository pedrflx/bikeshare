package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoUsaPixException extends BikeshareException
{

    public UsuarioNaoUsaPixException()
    {
        super("Usuario nao usa pix.");
    }
}