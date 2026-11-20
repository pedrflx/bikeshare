package br.ufal.ic.p2.bikeshare.models.bicicletas;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.NivelBateriaForaDoLimiteException;
import br.ufal.ic.p2.bikeshare.exceptions.NivelBateriaNaoNumericoException;
import br.ufal.ic.p2.bikeshare.exceptions.NivelBateriaNuloException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;
import br.ufal.ic.p2.bikeshare.exceptions.BateriaInsuficienteException;

/*
    bicicleta com bateria de 0 a 100
*/

public class BicicletaEletrica extends Bicicleta
{
    private static final int NIVEL_MINIMO = 15;

    private int nivelBateria;

    public BicicletaEletrica(String id, String nivelBateria) throws BikeshareException
    {
        super(id);
        this.nivelBateria = Conversor.converterInteiroEntre(nivelBateria, 0, 100, new NivelBateriaNuloException(), new NivelBateriaNaoNumericoException(), new NivelBateriaForaDoLimiteException());
    }

    @Override
    public String getTipo()
    {
        return "eletrica";
    }

    @Override
    public String getNivelBateria()
    {
        return String.valueOf(nivelBateria);
    }

    // além de estar livre, precisa ter bateria suficiente
    @Override
    public boolean estaDisponivel()
    {
        return super.estaDisponivel() && nivelBateria >= NIVEL_MINIMO;
    }

    @Override
    public void validarRetirada() throws BikeshareException
    {
        if (nivelBateria < NIVEL_MINIMO)
        {
            throw new BateriaInsuficienteException();
        }
    }
}