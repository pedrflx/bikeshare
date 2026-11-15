package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoEhPessoaFisicaException extends BikeshareException
{

    public UsuarioNaoEhPessoaFisicaException()
    {
        super("Usuario nao eh pessoa fisica.");
    }
}
