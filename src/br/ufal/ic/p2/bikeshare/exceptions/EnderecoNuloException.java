package br.ufal.ic.p2.bikeshare.exceptions;

public class EnderecoNuloException extends BikeshareException
{

    public EnderecoNuloException()
    {
        super("Endereco nao pode ser nulo.");
    }
}
