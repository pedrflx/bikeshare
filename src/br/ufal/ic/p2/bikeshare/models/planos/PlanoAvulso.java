package br.ufal.ic.p2.bikeshare.models.planos;

/*
    plano padrão do usuário. sem mensalidade, paga cada corrida
*/

public class PlanoAvulso extends Plano
{

    @Override
    public String getNome()
    {
        return "avulso";
    }
}