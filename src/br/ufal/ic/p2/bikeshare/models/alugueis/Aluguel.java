package br.ufal.ic.p2.bikeshare.models.alugueis;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.bicicletas.Bicicleta;
import br.ufal.ic.p2.bikeshare.models.estacoes.Estacao;
import br.ufal.ic.p2.bikeshare.models.usuarios.Usuario;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.io.Serializable;
import java.time.LocalDateTime;

/*
    uma corrida: quem retirou, qual bicicleta, de onde e quando
*/

public class Aluguel implements Serializable
{
    private String id;
    private Usuario usuario;
    private Bicicleta bicicleta;
    private Estacao estacaoOrigem;
    private LocalDateTime inicio;
    private String estado = "emAndamento";

    public Aluguel(String id, Usuario usuario, Bicicleta bicicleta, Estacao estacaoOrigem, LocalDateTime inicio)
    {
        this.id = id;
        this.usuario = usuario;
        this.bicicleta = bicicleta;
        this.estacaoOrigem = estacaoOrigem;
        this.inicio = inicio;
    }

    public String getAtributo(String atributo) throws BikeshareException
    {
        if (atributo.equals("estado"))
        {
            return estado;
        }
        else if (atributo.equals("usuario"))
        {
            return usuario.getId();
        }
        else if (atributo.equals("bicicleta"))
        {
            return bicicleta.getId();
        }
        else if (atributo.equals("estacaoOrigem"))
        {
            return estacaoOrigem.getId();
        }
        else if (atributo.equals("inicio"))
        {
            return Conversor.formatarData(inicio);
        }
        else if (atributo.equals("fim") || atributo.equals("estacaoDestino") || atributo.equals("valorCobrado"))
        {
            throw new AluguelEmAndamentoException();
        }

        throw new AtributoNaoExisteException();
    }

    public String getId()
    {
        return id;
    }
}