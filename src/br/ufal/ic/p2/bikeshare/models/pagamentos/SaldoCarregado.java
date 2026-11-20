package br.ufal.ic.p2.bikeshare.models.pagamentos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.ValorNaoNumericoException;
import br.ufal.ic.p2.bikeshare.exceptions.ValorNaoPositivoException;
import br.ufal.ic.p2.bikeshare.exceptions.ValorNuloException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import br.ufal.ic.p2.bikeshare.exceptions.SaldoInsuficienteException;


public class SaldoCarregado extends MetodoPag
{

    private double saldo = 0;

    @Override
    public String getNome()
    {
        return "saldoPreCarregado";
    }

    @Override
    public double getSaldo()
    {
        return saldo;
    }

    @Override
    public void recarregar(String valor) throws BikeshareException
    {
        saldo += Conversor.converterPositivo(valor, new ValorNuloException(), new ValorNaoNumericoException(), new ValorNaoPositivoException());
    }

    @Override
    public void validarRetirada() throws BikeshareException
    {
        if (saldo <= 0)
        {
            throw new SaldoInsuficienteException();
        }
    }
}