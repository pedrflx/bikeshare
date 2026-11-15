package br.ufal.ic.p2.bikeshare.exceptions;

/*
    BikeshareException
    mãe de todas as exceções do sistema
    cada erro tem a sua própria classe filha, com a mensagem exata que os testes esperam
*/

public abstract class BikeshareException extends Exception
{

    public BikeshareException(String mensagem)
    {
        super(mensagem);
    }
}
