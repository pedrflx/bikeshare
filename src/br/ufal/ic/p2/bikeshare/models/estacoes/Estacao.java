package br.ufal.ic.p2.bikeshare.models.estacoes;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.io.Serializable;
import br.ufal.ic.p2.bikeshare.models.bicicletas.Bicicleta;
import java.util.ArrayList;

/*
    ponto onde as bicicletas ficam: tem nome, endereço e um número fixo de vagas. qm diferencia as estações é o id (E1, E2...)
*/

public class Estacao implements Serializable
{

    private String id;
    private String nome;
    private String endereco;
    private int capacidade;
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();

    public Estacao(String id, String nome, String endereco, String capacidade) throws BikeshareException
    {
        Conversor.validarTexto(nome, new NomeNuloException());
        Conversor.validarTexto(endereco, new EnderecoNuloException());
        this.capacidade = Conversor.converterInteiroPositivo(capacidade, new CapacidadeNulaException(), new CapacidadeNaoNumericaException(), new CapacidadeNaoPositivaException());

        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getId()
    {
        return id;
    }


    // as bicicleta só entra se tiver vaga e passa a saber em qual estação está
    public void estacionar(Bicicleta bicicleta) throws BikeshareException
    {
        if (bicicletas.size() >= capacidade)
        {
            throw new EstacaoSemVagasException();
        }
        bicicletas.add(bicicleta);
        bicicleta.setEstacao(id);
    }

    public void verificarBicicleta(Bicicleta bicicleta) throws BikeshareException
    {
        if (!bicicletas.contains(bicicleta))
        {
            throw new BicicletaNaoEstaNaEstacaoException();
        }
    }

    public void retirar(Bicicleta bicicleta) throws BikeshareException
    {
        verificarBicicleta(bicicleta);
        bicicletas.remove(bicicleta);
    }

    // toda bicicleta ocupa vaga, mesmo a que não está disponível
    public String getVagasDisponiveis()
    {
        return String.valueOf(capacidade - bicicletas.size());
    }

    public String getBicicletasDisponiveis()
    {
        int disponiveis = 0;
        for (Bicicleta bicicleta : bicicletas)
        {
            if (bicicleta.estaDisponivel())
            {
                disponiveis++;
            }
        }
        return String.valueOf(disponiveis);
    }
}