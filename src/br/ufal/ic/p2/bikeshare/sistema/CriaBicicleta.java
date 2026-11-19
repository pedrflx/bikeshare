package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.*;
import br.ufal.ic.p2.bikeshare.models.bicicletas.Bicicleta;
import br.ufal.ic.p2.bikeshare.models.bicicletas.BicicletaEletrica;
import br.ufal.ic.p2.bikeshare.models.bicicletas.BicicletaNormal;

/*
    transforma o texto do tipo na bicicleta certa (único lugar que decide entre normal e elétrica)
*/

public class CriaBicicleta
{
    public static Bicicleta criar(String id, String tipo) throws BikeshareException
    {
        if ("convencional".equals(tipo))
        {
            return new BicicletaNormal(id);
        }
        if ("eletrica".equals(tipo))
        {
            throw new NivelBateriaNuloException();
        }
        throw new TipoInvalidoException();
    }

    public static Bicicleta criar(String id, String tipo, String nivelBateria) throws BikeshareException
    {
        if ("eletrica".equals(tipo))
        {
            return new BicicletaEletrica(id, nivelBateria);
        }
        if ("convencional".equals(tipo))
        {
            throw new BicicletaNaoPossuiBateriaException();
        }
        throw new TipoInvalidoException();
    }
}