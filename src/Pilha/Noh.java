package Pilha;

/**
 * Classe modeladora dos nós internos da estrutura da Pilha.
 * @author Francisco Afonso de Oliveira Neto
 */
public class Noh <T> {
    private T valor;
    private Noh<T> proximo;

    public Noh (T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public Noh (T valor, Noh<T> proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }

    public T getValor () {
        return valor;
    }

    public Noh<T> getProximo () {
        return proximo;
    }

    public void setValor (T valor) {
        this.valor = valor;
    }

    public void setProximo (Noh<T> proximo) {
        this.proximo = proximo;
    }

    public boolean basePilha () {
        return proximo == null;
    }
}
