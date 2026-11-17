package br.ufal.ic.p2.bikeshare.exceptions;

public class AtributoNaoPodeSerAlteradoException extends BikeshareException
{

    public AtributoNaoPodeSerAlteradoException()
    {
        super("Atributo nao pode ser alterado.");
    }
}
