package br.ufal.ic.p2.bikeshare.models.pagamento;

/*
    forma de pagamento de quem ainda não cadastrou nenhuma
*/

public class SemPagamento extends MetodoPagamento
{

    @Override
    public String getNome()
    {
        return "nenhum";
    }
}