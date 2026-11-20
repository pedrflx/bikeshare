package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.alugueis.Aluguel;
import br.ufal.ic.p2.bikeshare.models.bicicletas.Bicicleta;
import br.ufal.ic.p2.bikeshare.models.estacoes.Estacao;
import br.ufal.ic.p2.bikeshare.models.usuarios.Usuario;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
    guarda os aluguéis, gera os ids e conduz a retirada
*/

public class RepositorioAlugueis extends Repositorio
{

    private ArrayList<Aluguel> alugueis = new ArrayList<>();
    public RepositorioAlugueis()
    {
        super("A");
    }

    // confere tudo na ordem do teste antes de mexer em qualquer coisa
    public String retirar(Usuario usuario, Estacao estacao, Bicicleta bicicleta, String data) throws BikeshareException
    {
        LocalDateTime inicio = Conversor.converterData(data, new DataNulaException(), new DataInvalidaException());
        usuario.verificarSemAluguel();
        estacao.verificarBicicleta(bicicleta);
        bicicleta.validarRetirada();
        usuario.validarPagamento();

        Aluguel novo = new Aluguel(proximoId(), usuario, bicicleta, estacao, inicio);
        estacao.retirar(bicicleta);
        bicicleta.iniciarUso();
        usuario.iniciarAluguel(novo.getId());
        alugueis.add(novo);
        gastarId();
        return novo.getId();
    }

    public Aluguel buscar(String id) throws BikeshareException
    {
        Conversor.validarTexto(id, new IdentificacaoAluguelNulaException());

        for (Aluguel aluguel : alugueis)
        {
            if (aluguel.getId().equals(id))
            {
                return aluguel;
            }
        }
        throw new AluguelNaoExisteException();
    }
}