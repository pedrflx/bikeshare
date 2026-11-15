package br.ufal.ic.p2.bikeshare.models.planos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.PlanoInvalidoException;
import br.ufal.ic.p2.bikeshare.exceptions.PlanoSemMensalidadeException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

/*
    mãe dos planos de cobrança do usuário
*/

public abstract class Plano
{

    public abstract String getNome();

    public double getMensalidade() throws BikeshareException
    {
        throw new PlanoSemMensalidadeException();
    }

    // transforma o texto do teste no plano certo. o avulso não aceita mensalidade
    public static Plano criar(String nome, String mensalidade) throws BikeshareException
    {
        if ("avulso".equals(nome))
        {
            if (!Conversor.ehVazio(mensalidade)) throw new PlanoSemMensalidadeException();
            return new PlanoAvulso();
        }
        if ("assinante".equals(nome))
        {
            return new PlanoAssinante(mensalidade);
        }
        throw new PlanoInvalidoException();
    }
}