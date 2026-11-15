package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.TipoInvalidoException;
import br.ufal.ic.p2.bikeshare.models.planos.Plano;
import br.ufal.ic.p2.bikeshare.models.usuarios.PF;
import br.ufal.ic.p2.bikeshare.models.usuarios.PJ;
import br.ufal.ic.p2.bikeshare.models.usuarios.Usuario;

/*
    transforma o texto do tipo no usuário certo
*/

public class FabricaUsuario
{

    // sem plano informado o usuário fica no avulso
    public static Usuario criar(String id, String nome, String email, String senha, String tipo, String cpf) throws BikeshareException
    {
        return criar(id, nome, email, senha, tipo, cpf, "avulso", "");
    }

    public static Usuario criar(String id, String nome, String email, String senha, String tipo, String cnpj, String razaoSocial) throws BikeshareException
    {
        return criar(id, nome, email, senha, tipo, cnpj, razaoSocial, "avulso", "");
    }

    public static Usuario criar(String id, String nome, String email, String senha, String tipo, String cpf, String plano, String mensalidade) throws BikeshareException
    {
        if (!"pessoaFisica".equals(tipo))
        {
            throw new TipoInvalidoException();
        }

        Usuario usuario = new PF(id, nome, email, senha, cpf);
        usuario.setPlano(Plano.criar(plano, mensalidade));
        return usuario;
    }

    public static Usuario criar(String id, String nome, String email, String senha, String tipo, String cnpj, String razaoSocial, String plano, String mensalidade) throws BikeshareException
    {
        if (!"pessoaJuridica".equals(tipo))
        {
            throw new TipoInvalidoException();
        }

        Usuario usuario = new PJ(id, nome, email, senha, cnpj, razaoSocial);
        usuario.setPlano(Plano.criar(plano, mensalidade));
        return usuario;
    }
}