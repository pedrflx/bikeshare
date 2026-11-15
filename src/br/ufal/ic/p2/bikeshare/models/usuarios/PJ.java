package br.ufal.ic.p2.bikeshare.models.usuarios;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.CnpjNuloException;
import br.ufal.ic.p2.bikeshare.exceptions.RazaoSocialNulaException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

/*
    usuário identificado por CNPJ e razão social
*/

public class PJ extends Usuario
{

    private String cnpj;
    private String razaoSocial;

    public PJ(String id, String nome, String email, String senha, String cnpj, String razaoSocial) throws BikeshareException
    {
        super(id, nome, email, senha);

        Conversor.validarTexto(cnpj, new CnpjNuloException());
        Conversor.validarTexto(razaoSocial, new RazaoSocialNulaException());
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getTipo()
    {
        return "pessoaJuridica";
    }

    @Override
    public String getCnpj()
    {
        return cnpj;
    }

    @Override
    public String getRazaoSocial()
    {
        return razaoSocial;
    }
}