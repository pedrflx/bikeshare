package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.bicicletas.Bicicleta;
import br.ufal.ic.p2.bikeshare.models.estacoes.Estacao;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.io.Serializable;
import java.util.ArrayList;

/*
    guarda todas as bicicletas do sistema
*/

public class RepositorioBicicletas implements Serializable
{

    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();

    // confere o id antes de criar a bicicleta (teste cobra esse erro antes do tipo
    public String validarNovoId(String id) throws BikeshareException
    {
        Conversor.validarTexto(id, new IdentificacaoBicicletaNulaException());

        for (Bicicleta bicicleta : bicicletas)
        {
            if (bicicleta.getId().equals(id))
            {
                throw new BicicletaJaExisteException();
            }
        }
        return id;
    }

    //só entra na lista se couber
    public void adicionar(Estacao estacao, Bicicleta nova) throws BikeshareException
    {
        estacao.estacionar(nova);
        bicicletas.add(nova);
    }

    public Bicicleta buscar(String id) throws BikeshareException
    {
        Conversor.validarTexto(id, new IdentificacaoBicicletaNulaException());

        for (Bicicleta bicicleta : bicicletas)
        {
            if (bicicleta.getId().equals(id))
            {
                return bicicleta;
            }
        }
        throw new BicicletaNaoExisteException();
    }

    public void remover(Estacao estacao, String id) throws BikeshareException
    {
        Bicicleta bicicleta = buscar(id);

        estacao.retirar(bicicleta);
        bicicletas.remove(bicicleta);
    }
}