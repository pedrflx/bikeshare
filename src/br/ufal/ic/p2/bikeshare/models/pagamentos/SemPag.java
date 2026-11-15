package br.ufal.ic.p2.bikeshare.models.pagamentos;

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
}