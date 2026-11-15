package br.ufal.ic.p2.bikeshare.exceptions;

/*
    mãe de todas as exceções do sistema
*/

public abstract class BikeshareException extends Exception
{

    public BikeshareException(String mensagem)
    {
        super(mensagem);
    }
}
