package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.usuarios.Usuario;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.util.ArrayList;

/*
    guarda os usuários cadastrados, gera os ids (U1, U2...) e procura por id
*/

public class RepositorioUsuarios extends Repositorio
{

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public RepositorioUsuarios()
    {
        super("U");
    }

    public String adicionar(Usuario novo) throws BikeshareException
    {
        verificarEmailLivre(novo.getEmail(), novo);

        usuarios.add(novo);
        gastarId();
        return novo.getId();
    }

    // o email é o único dado que depende dos outros usuários
    public void alterar(String id, String atributo, String valor) throws BikeshareException
    {
        Usuario usuario = buscar(id);

        if (atributo.equals("email"))
        {
            verificarEmailLivre(valor, usuario);
        }
        usuario.alterar(atributo, valor);
    }

    // o email não pode ser de outro usuário
    private void verificarEmailLivre(String email, Usuario dono) throws BikeshareException
    {
        for (Usuario usuario : usuarios)
        {
            if (usuario != dono && usuario.getEmail().equalsIgnoreCase(email))
            {
                throw new EmailJaCadastradoException();
            }
        }
    }

    public Usuario buscar(String id) throws BikeshareException
    {
        Conversor.validarTexto(id, new IdentificacaoUsuarioNulaException());

        for (Usuario usuario : usuarios)
        {
            if (usuario.getId().equals(id))
            {
                return usuario;
            }
        }
        throw new UsuarioNaoExisteException();
    }

    // id do removido não volta a ser usado
    public void remover(String id) throws BikeshareException
    {
        Usuario usuario = buscar(id);

        usuario.validarRemocao();
        usuarios.remove(usuario);
    }

    // o email é procurado sem diferenciar maiúscula de minúscula, igual ao cadastro
    public String buscarPorEmail(String email) throws BikeshareException {
        Conversor.validarTexto(email, new EmailNuloException());

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario.getId();
            }
        }
        throw new UsuarioNaoExisteException();
    }
}