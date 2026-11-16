package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.usuarios.Usuario;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.util.ArrayList;

/*
    guarda os usuários cadastrados, gera os ids (U1, U2...) e procura por id
*/

public class RepositorioUsuarios
{

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private int ultimoId = 0;

    // só mostra o próximo id
    public String proximoId()
    {
        return "U" + (ultimoId + 1);
    }

    public String adicionar(Usuario novo) throws BikeshareException
    {
        for (Usuario usuario : usuarios)
        {
            if (usuario.getEmail().equalsIgnoreCase(novo.getEmail()))
            {
                throw new EmailJaCadastradoException();
            }
        }

        usuarios.add(novo);
        ultimoId++;
        return novo.getId();
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

    // o email é procurado sem diferenciar maiúscula de minúscula, igual ao cadastro
    public String buscarPorEmail(String email) throws BikeshareException
    {
        Conversor.validarTexto(email, new EmailNuloException());

        for (Usuario usuario : usuarios)
        {
            if (usuario.getEmail().equalsIgnoreCase(email))
            {
                return usuario.getId();
            }
        }
        throw new UsuarioNaoExisteException();
    }

    public void zerar()
    {
        usuarios = new ArrayList<>();
        ultimoId = 0;
    }
}