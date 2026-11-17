package br.ufal.ic.p2.bikeshare.sistema;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import br.ufal.ic.p2.bikeshare.exceptions.PersistenciaException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
    grava e lê os dados do sistema em um arquivo (usando Serializable)
*/

public class Persistencia
{

    private static final String ARQUIVO = "bikeshare_data.ser";

    public static void salvar(Dados dados) throws BikeshareException
    {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(ARQUIVO)))
        {
            saida.writeObject(dados);
        }
        catch (IOException e)
        {
            throw new PersistenciaException();
        }
    }

    // sem arquivo, ou com um arquivo antigo que não dá mais pra ler, o sistema começa vazio
    public static Dados carregar()
    {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARQUIVO)))
        {
            return (Dados) entrada.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            return new Dados();
        }
    }
}