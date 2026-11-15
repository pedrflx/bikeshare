package br.ufal.ic.p2.bikeshare.exceptions;

public class AtributoNaoExisteException extends BikeshareException
{

    public AtributoNaoExisteException()
    {
        super("Atributo nao existe.");
    }
}
