package br.ufal.ic.p2.bikeshare.models.pagamentos;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.ChavePixNulaException;
import br.ufal.ic.p2.bikeshare.utils.Conversor;

public class Pix extends MetodoPag
{
    private String chave;

    public Pix(String chave) throws BikeshareException
    {
        Conversor.validarTexto(chave, new ChavePixNulaException());
        this.chave = chave;
    }

    @Override
    public String getNome()
    {
        return "pix";
    }

    @Override
    public String getChavePix()
    {
        return chave;
    }
}