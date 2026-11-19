package br.ufal.ic.p2.bikeshare.exceptions;

public class BicicletaNaoEstaNaEstacaoException extends BikeshareException
{
    public BicicletaNaoEstaNaEstacaoException()
    {
        super("Bicicleta nao esta nesta estacao.");
    }
}
