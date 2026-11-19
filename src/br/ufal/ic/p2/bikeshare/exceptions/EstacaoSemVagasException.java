package br.ufal.ic.p2.bikeshare.exceptions;

public class EstacaoSemVagasException extends BikeshareException
{
    public EstacaoSemVagasException()
    {
        super("Estacao sem vagas disponiveis.");
    }
}
