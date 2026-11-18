package br.ufal.ic.p2.bikeshare.models.estacoes;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.io.Serializable;

/*
    ponto onde as bicicletas ficam: tem nome, endereço e um número fixo de vagas. qm diferencia as estações é o id (E1, E2...)
*/

public class Estacao implements Serializable
{

    private String id;
    private String nome;
    private String endereco;
    private int capacidade;

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


    public String getVagasDisponiveis()
    {
        return String.valueOf(capacidade);
    }

    public String getBicicletasDisponiveis()
    {
        return "0";
    }
}