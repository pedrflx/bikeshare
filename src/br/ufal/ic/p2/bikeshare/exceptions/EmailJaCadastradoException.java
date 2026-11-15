package br.ufal.ic.p2.bikeshare.exceptions;

public class EmailJaCadastradoException extends BikeshareException
{

    public EmailJaCadastradoException()
    {
        super("Email ja cadastrado.");
    }
}
