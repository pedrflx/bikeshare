package br.ufal.ic.p2.bikeshare.exceptions;

public class IdentificacaoBicicletaNulaException extends BikeshareException
{
    public IdentificacaoBicicletaNulaException()
    {
        super("Identificacao da bicicleta nao pode ser nula.");
    }
}
