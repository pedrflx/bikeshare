package br.ufal.ic.p2.bikeshare.models.usuarios;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.pagamentos.MetodoPag;
import br.ufal.ic.p2.bikeshare.models.pagamentos.SemPag;
import br.ufal.ic.p2.bikeshare.models.planos.Plano;
import br.ufal.ic.p2.bikeshare.models.planos.PlanoAvulso;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

/*
    mãe dos dois tipos de usuário: Pessoa Fisica(PF) e Pessoa Juridica(PJ)
*/

public abstract class Usuario
{

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String estado = "ativo";
    private Plano plano = new PlanoAvulso();
    private MetodoPag metodoPagamento = new SemPag();
    private String aluguelAtivo = "nenhum";
    private double totalPendencias = 0;

    public Usuario(String id, String nome, String email, String senha) throws BikeshareException
    {
        this.id = id;
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public abstract String getTipo();

    // documentos de cada tipo: na mãe dão erro, e cada filha sobrescreve os seus
    public String getCpf() throws BikeshareException
    {
        throw new UsuarioNaoEhPessoaFisicaException();
    }

    public String getCnpj() throws BikeshareException
    {
        throw new UsuarioNaoEhPessoaJuridicaException();
    }

    public String getRazaoSocial() throws BikeshareException
    {
        throw new UsuarioNaoEhPessoaJuridicaException();
    }

    // devolve o valor de um atributo pelo nome que vem do teste
    public String getAtributo(String atributo) throws BikeshareException
    {
        if (atributo.equals("nome"))
        {
            return nome;
        }
        else if (atributo.equals("email"))
        {
            return email;
        }
        else if (atributo.equals("tipo"))
        {
            return getTipo();
        }
        else if (atributo.equals("senha"))
        {
            return senha;
        }
        else if (atributo.equals("estado"))
        {
            return estado;
        }
        else if (atributo.equals("plano"))
        {
            return plano.getNome();
        }
        else if (atributo.equals("mensalidade"))
        {
            return Conversor.formatarValor(plano.getMensalidade());
        }
        else if (atributo.equals("metodoPagamento"))
        {
            return metodoPagamento.getNome();
        }
        else if (atributo.equals("numeroCartao"))
        {
            return metodoPagamento.getNumeroCartao();
        }
        else if (atributo.equals("validadeCartao"))
        {
            return metodoPagamento.getValidadeCartao();
        }
        else if (atributo.equals("chavePix"))
        {
            return metodoPagamento.getChavePix();
        }
        else if (atributo.equals("saldo"))
        {
            return Conversor.formatarValor(metodoPagamento.getSaldo());
        }
        else if (atributo.equals("aluguelAtivo"))
        {
            return aluguelAtivo;
        }
        else if (atributo.equals("totalPendencias"))
        {
            return Conversor.formatarValor(totalPendencias);
        }
        else if (atributo.equals("cpf"))
        {
            return getCpf();
        }
        else if (atributo.equals("cnpj"))
        {
            return getCnpj();
        }
        else if (atributo.equals("razaoSocial"))
        {
            return getRazaoSocial();
        }

        throw new AtributoNaoExisteException();
    }

    public String getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setNome(String nome) throws BikeshareException
    {
        Conversor.validarTexto(nome, new NomeNuloException());
        this.nome = nome;
    }

    // o email precisa ter @, se repete ou não é o repositório que confere, porque só ele vê todos os usuários
    public void setEmail(String email) throws BikeshareException
    {
        Conversor.validarTexto(email, new EmailNuloException());

        if (!email.contains("@"))
        {
            throw new EmailInvalidoException();
        }
        this.email = email;
    }

    public void setSenha(String senha) throws BikeshareException
    {
        Conversor.validarTexto(senha, new SenhaNulaException());
        this.senha = senha;
    }

    public void setPlano(Plano plano) throws BikeshareException
    {
        if (plano == null)
        {
            throw new PlanoInvalidoException();
        }
        this.plano = plano;
    }
}