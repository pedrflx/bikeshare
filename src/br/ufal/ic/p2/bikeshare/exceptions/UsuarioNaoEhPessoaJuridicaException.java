package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioNaoEhPessoaJuridicaException extends BikeshareException
{

    public UsuarioNaoEhPessoaJuridicaException()
    {
        super("Usuario nao eh pessoa juridica.");
    }
}
