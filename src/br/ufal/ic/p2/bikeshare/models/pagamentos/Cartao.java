package br.ufal.ic.p2.bikeshare.models.pagamentos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.NumeroCartaoNuloException;
import br.ufal.ic.p2.bikeshare.exceptions.ValidadeCartaoInvalidaException;
import br.ufal.ic.p2.bikeshare.exceptions.ValidadeCartaoNulaException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;


public class Cartao extends MetodoPag
{

    private String numero;
    private String validade;

    public Cartao(String numero, String validade) throws BikeshareException
    {
        Conversor.validarTexto(numero, new NumeroCartaoNuloException());
        Conversor.validarTexto(validade, new ValidadeCartaoNulaException());

        if (!validade.matches("(0[1-9]|1[0-2])/\\d{4}"))
        {
            throw new ValidadeCartaoInvalidaException();
        }
        this.numero = numero;
        this.validade = validade;
    }

    @Override
    public String getNome()
    {
        return "cartao";
    }

    @Override
    public String getNumeroCartao()
    {
        return numero;
    }

    @Override
    public String getValidadeCartao()
    {
        return validade;
    }
}