package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoUsaSaldoException extends BikeshareException
{

    public UsuarioNaoUsaSaldoException()
    {
        super("Usuario nao usa saldo pre-carregado.");
    }
}