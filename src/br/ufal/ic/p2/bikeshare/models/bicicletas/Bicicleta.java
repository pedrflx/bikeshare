package br.ufal.ic.p2.bikeshare.models.bicicletas;

import br.ufal.ic.p2.bikeshare.exceptions.AtributoNaoExisteException;
import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.BicicletaNaoPossuiBateriaException;
import java.io.Serializable;

/*
    mãe dos dois tipos de bicicleta
*/

public abstract class Bicicleta implements Serializable
{
    private String id;
    private String estado = "disponivel";
    private String estacao = "nenhuma";

    public Bicicleta(String id)
    {
        this.id = id;
    }

    public abstract String getTipo();

    // amãe não tem bateria
    public String getNivelBateria() throws BikeshareException
    {
        throw new BicicletaNaoPossuiBateriaException();
    }
    public boolean estaDisponivel()
    {
        return estado.equals("disponivel");
    }

    public String getAtributo(String atributo) throws BikeshareException
    {
        if (atributo.equals("tipo"))
        {
            return getTipo();
        }
        else if (atributo.equals("estado"))
        {
            return estado;
        }
        else if (atributo.equals("estacao"))
        {
            return estacao;
        }
        else if (atributo.equals("nivelBateria"))
        {
            return getNivelBateria();
        }

        throw new AtributoNaoExisteException();
    }

    public String getId()
    {
        return id;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstacao(String estacao)
    {
        this.estacao = estacao;
    }
}