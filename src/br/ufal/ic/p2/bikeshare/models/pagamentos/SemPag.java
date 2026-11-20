package br.ufal.ic.p2.bikeshare.models.pagamentos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.MetodoPagamentoNaoCadastradoException;

/*
    forma de pagamento de quem ainda não cadastrou nenhuma
*/

public class SemPag extends MetodoPag
{

    @Override
    public String getNome()
    {
        return "nenhum";
    }

    @Override
    public void validarRetirada() throws BikeshareException
    {
        throw new MetodoPagamentoNaoCadastradoException();
    }
}