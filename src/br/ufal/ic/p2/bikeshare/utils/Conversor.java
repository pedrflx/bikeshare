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

    // lê um valor com vírgula ("120,50") e confere se não é vazio e se é número
    private static double converterNumero(String valor, BikeshareException nulo, BikeshareException naoNumerico) throws BikeshareException
    {
        validarTexto(valor, nulo);
        try
        {
            return Double.parseDouble(valor.trim().replace(",", "."));
        }
        catch (NumberFormatException e)
        {
            throw naoNumerico;
        }
    }

    // aceita zero, como a mensalidade
    public static double converterNaoNegativo(String valor, BikeshareException nulo, BikeshareException naoNumerico, BikeshareException negativo) throws BikeshareException
    {
        double numero = converterNumero(valor, nulo, naoNumerico);
        if (numero < 0)
        {
            throw negativo;
        }
        return numero;
    }

    // não aceita zero, como a recarga de saldo
    public static double converterPositivo(String valor, BikeshareException nulo, BikeshareException naoNumerico, BikeshareException naoPositivo) throws BikeshareException
    {
        double numero = converterNumero(valor, nulo, naoNumerico);
        if (numero <= 0)
        {
            throw naoPositivo;
        }
        return numero;
    }

    // lê um número inteiro ("10"). "2,5", "5.0" e "1e3" não são inteiros
    private static int converterInteiro(String valor, BikeshareException nulo, BikeshareException naoNumerico) throws BikeshareException
    {
        validarTexto(valor, nulo);
        try
        {
            return Integer.parseInt(valor.trim());
        }
        catch (NumberFormatException e)
        {
            throw naoNumerico;
        }
    }

    public static int converterInteiroPositivo(String valor, BikeshareException nulo, BikeshareException naoNumerico, BikeshareException naoPositivo) throws BikeshareException
    {
        int numero = converterInteiro(valor, nulo, naoNumerico);
        if (numero <= 0)
        {
            throw naoPositivo;
        }
        return numero;
    }

    public static int converterInteiroEntre(String valor, int minimo, int maximo, BikeshareException nulo, BikeshareException naoNumerico, BikeshareException foraDoLimite) throws BikeshareException
    {
        int numero = converterInteiro(valor, nulo, naoNumerico);
        if (numero < minimo || numero > maximo)
        {
            throw foraDoLimite;
        }
        return numero;
    }

    // 50 vira "50,00" e 120.5 vira "120,50"
    public static String formatarValor(double valor)
    {
        return String.format(Locale.US, "%.2f", valor).replace(".", ",");
    }
}