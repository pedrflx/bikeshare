package br.ufal.ic.p2.bikeshare.utils;

import br.ufal.ic.p2.bikeshare.exceptions.BikeshareException;
import java.util.Locale;

/*
    reúne as validações e conversões de texto que várias classes usam
    os métodos recebem a exceção que devem lançar
*/

public class Conversor
{

    // texto nulo, vazio ou só com espaços conta como vazio
    public static boolean ehVazio(String texto)
    {
        return texto == null || texto.trim().isEmpty();
    }

    public static void validarTexto(String texto, BikeshareException erro) throws BikeshareException
    {
        if (ehVazio(texto))
        {
            throw erro;
        }
    }

    // lê um valor com vírgula ("120,50") e confere se não é vazio, se é número e se não é negativo
    public static double converterNaoNegativo(String valor, BikeshareException nulo, BikeshareException naoNumerico, BikeshareException negativo) throws BikeshareException
    {
        validarTexto(valor, nulo);

        double numero;
        try
        {
            numero = Double.parseDouble(valor.trim().replace(",", "."));
        }
        catch (NumberFormatException e)
        {
            throw naoNumerico;
        }

        if (numero < 0)
        {
            throw negativo;
        }
        return numero;
    }

    // 50 vira "50,00" e 120.5 vira "120,50"
    public static String formatarValor(double valor)
    {
        return String.format(Locale.US, "%.2f", valor).replace(".", ",");
    }
}