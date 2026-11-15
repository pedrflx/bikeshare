package br.ufal.ic.p2.bikeshare.exceptions;

public class CnpjNuloException extends BikeshareException
{

    public CnpjNuloException()
    {
        super("CNPJ nao pode ser nulo.");
    }
}
