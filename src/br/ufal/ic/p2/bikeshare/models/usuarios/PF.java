package br.ufal.ic.p2.bikeshare.models.usuarios;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.CpfNuloException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

/*
    usuário identificado por CPF
*/

public class PF extends Usuario
{

    private String cpf;

    public PF(String id, String nome, String email, String senha, String cpf) throws BikeshareException
    {
        super(id, nome, email, senha);

        Conversor.validarTexto(cpf, new CpfNuloException());
        this.cpf = cpf;
    }

    @Override
    public String getTipo()
    {
        return "pessoaFisica";
    }

    @Override
    public String getCpf()
    {
        return cpf;
    }
}