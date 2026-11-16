package br.ufal.ic.p2.bikeshare.models.pagamentos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.UsuarioNaoUsaCartaoException;
import br.ufal.ic.p2.bikeshare.exceptions.UsuarioNaoUsaPixException;
import br.ufal.ic.p2.bikeshare.exceptions.UsuarioNaoUsaSaldoException;

/*
    mãe das formas de pagamento do usuario
*/

public abstract class MetodoPag
{

    public abstract String getNome();

    public String getNumeroCartao() throws BikeshareException
    {
        throw new UsuarioNaoUsaCartaoException();
    }

    public String getValidadeCartao() throws BikeshareException
    {
        throw new UsuarioNaoUsaCartaoException();
    }

    public String getChavePix() throws BikeshareException
    {
        throw new UsuarioNaoUsaPixException();
    }

    public double getSaldo() throws BikeshareException
    {
        throw new UsuarioNaoUsaSaldoException();
    }
}