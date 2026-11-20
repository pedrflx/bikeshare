package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioJaPossuiAluguelException extends BikeshareException
{

    public UsuarioJaPossuiAluguelException()
    {
        super("Usuario ja possui um aluguel em andamento.");
    }
}
