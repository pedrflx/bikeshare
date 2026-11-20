package br.ufal.ic.p2.bikeshare.models.usuarios;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.pagamentos.MetodoPag;
import br.ufal.ic.p2.bikeshare.models.pagamentos.SemPag;
import br.ufal.ic.p2.bikeshare.models.planos.Plano;
import br.ufal.ic.p2.bikeshare.models.planos.PlanoAvulso;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.io.Serializable;
import br.ufal.ic.p2.bikeshare.models.pagamentos.Cartao;
import br.ufal.ic.p2.bikeshare.models.pagamentos.Pix;
import br.ufal.ic.p2.bikeshare.models.pagamentos.SaldoCarregado;

/*
    mãe dos dois tipos de usuário: Pessoa Fisica(PF) e Pessoa Juridica(PJ)
*/

public abstract class Usuario implements Serializable
{
    private static final String SEM_ALUGUEL = "nenhum";
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String estado = "ativo";
    private Plano plano = new PlanoAvulso();
    private MetodoPag metodoPagamento = new SemPag();
    private SaldoCarregado saldoCarregado = new SaldoCarregado();
    private String aluguelAtivo = SEM_ALUGUEL;
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

    public void verificarSemAluguel() throws BikeshareException
    {
        if (!aluguelAtivo.equals(SEM_ALUGUEL))
        {
            throw new UsuarioJaPossuiAluguelException();
        }
    }

    public void validarRemocao() throws BikeshareException
    {
        if (!aluguelAtivo.equals(SEM_ALUGUEL))
        {
            throw new UsuarioComAluguelException();
        }
    }

    public void validarPagamento() throws BikeshareException
    {
        metodoPagamento.validarRetirada();
    }

    public void iniciarAluguel(String aluguel)
    {
        aluguelAtivo = aluguel;
    }

    public String getId()
    {
        return id;
    }

    public void alterar(String atributo, String valor) throws BikeshareException
    {
        if (atributo.equals("nome"))
        {
            setNome(valor);
        }
        else if (atributo.equals("email"))
        {
            setEmail(valor);
        }
        else if (atributo.equals("senha"))
        {
            setSenha(valor);
        }
        else if (atributo.equals("plano"))
        {
            alterarPlano(valor);
        }
        else if (atributo.equals("saldo"))
        {
            metodoPagamento.recarregar(valor);
        }
        else if (atributo.equals("metodoPagamento"))
        {
            validarEscolha(atributo, valor, "saldoPreCarregado");
            metodoPagamento = saldoCarregado;
        }
        else
        {
            throw new AtributoNaoPodeSerAlteradoException();
        }
    }

    // com a chave, só dá pra escolher pix
    public void alterar(String atributo, String valor, String chave) throws BikeshareException
    {
        validarEscolha(atributo, valor, "pix");
        metodoPagamento = new Pix(chave);
    }

    // com número e validade, só dá pra escolher cartão
    public void alterar(String atributo, String valor, String numero, String validade) throws BikeshareException
    {
        validarEscolha(atributo, valor, "cartao");
        metodoPagamento = new Cartao(numero, validade);
    }

    private void validarEscolha(String atributo, String valor, String esperado) throws BikeshareException
    {
        if (!atributo.equals("metodoPagamento"))
        {
            throw new AtributoNaoPodeSerAlteradoException();
        }
        if (!esperado.equals(valor))
        {
            throw new MetodoPagamentoInvalidoException();
        }
    }

    // escolher o plano que já tem não muda nada
    private void alterarPlano(String nome) throws BikeshareException
    {
        if (!plano.getNome().equals(nome))
        {
            setPlano(Plano.criar(nome));
        }
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