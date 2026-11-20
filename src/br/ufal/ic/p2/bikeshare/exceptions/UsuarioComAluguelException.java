package br.ufal.ic.p2.bikeshare.exceptions;

public class UsuarioComAluguelException extends BikeshareException
{

    public UsuarioComAluguelException()
    {
        super("Nao e possivel remover usuario com aluguel em andamento.");
    }
}
