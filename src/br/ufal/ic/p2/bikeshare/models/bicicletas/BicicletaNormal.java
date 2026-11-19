package br.ufal.ic.p2.bikeshare.models.bicicletas;

/*
    bicicleta comum, sem bateria
*/

public class BicicletaNormal extends Bicicleta
{

    public BicicletaNormal(String id)
    {
        super(id);
    }

    @Override
    public String getTipo()
    {
        return "convencional";
    }
}