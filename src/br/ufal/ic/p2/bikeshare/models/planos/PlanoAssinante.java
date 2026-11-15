package br.ufal.ic.p2.bikeshare.models.planos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.MensalidadeNaoNumericaException;
import br.ufal.ic.p2.bikeshare.exceptions.MensalidadeNegativaException;
import br.ufal.ic.p2.bikeshare.exceptions.MensalidadeNulaException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

/*
    plano com mensalidade. ela é validada no construtor, então nunca existe assinante sem mensalidade
*/

public class PlanoAssinante extends Plano
{

    private double mensalidade;

    public PlanoAssinante(String mensalidade) throws BikeshareException
    {
        this.mensalidade = Conversor.converterNaoNegativo(mensalidade, new MensalidadeNulaException(), new MensalidadeNaoNumericaException(), new MensalidadeNegativaException());
    }

    @Override
    public String getNome()
    {
        return "assinante";
    }

    @Override
    public double getMensalidade()
    {
        return mensalidade;
    }
}