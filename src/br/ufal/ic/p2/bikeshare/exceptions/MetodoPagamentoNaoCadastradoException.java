package br.ufal.ic.p2.bikeshare.exceptions;

public class MetodoPagamentoNaoCadastradoException extends BikeshareException
{

    public MetodoPagamentoNaoCadastradoException()
    {
        super("Metodo de pagamento nao cadastrado.");
    }
}
