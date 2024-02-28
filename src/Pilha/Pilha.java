package Pilha;

import java.util.Scanner;

/**
 * Classe modeladora da Estrutura de Dados Pilha
 * 
 * Conceito LIFO (Last In First Out) - Primeiro a entrar, ultimo a sair
 * 
 * @author Francisco Afonso de Oliveira Neto 
 */
public class Pilha<T> {
    private static Scanner console = new Scanner(System.in);
    private Noh<T> ponteiroTopo;
    private int tamanhoPilha;

    public Pilha () {
        ponteiroTopo = null;
        tamanhoPilha = 0;
    }

    /**
     * Método responsável por adicionar um elemento no topo da pilha
     * 
     * @param valor - Valor a ser empilhado
     */
    public void empilhar (T valor) {
        if (ponteiroTopo == null) {
            ponteiroTopo = new Noh<T>(valor);
        }
        else {
            Noh<T> aux = new Noh<T>(valor);
            aux.setProximo(ponteiroTopo);
            ponteiroTopo = aux;
        }
        tamanhoPilha++;
    }

    /**
     * Método responsável por remover o elemento que está no topo da pilha
     */
    public void desempilhar () {
        if (tamanhoPilha == 0) {
            System.out.println("Não foi possível desempilhar. Pilha vazia!");
        }
        else {
            Noh<T> aux = ponteiroTopo;
            ponteiroTopo = ponteiroTopo.getProximo();
            tamanhoPilha--;
            System.out.println("eliminando do topo:" + aux.getValor());
        }
    }

    /**
     * Método responsável por visualizar o elemento que está no topo da pilha
     * 
     * @return - Valor do elemento do topo ou nulo, caso a pilha for vazia
     */
    public T getTopo () {
        return (tamanhoPilha == 0) ? null : ponteiroTopo.getValor();
    }

    /**
     * Método responsável por vizualizar todos os elementos da pilha
     */
    public void mostrarPilha () {
        System.out.println("Mostrando a pilha:");
        Noh<T> aux = ponteiroTopo;

        for (int i=0; i<tamanhoPilha; i++) {
            System.out.println(aux.getValor());
            aux = aux.getProximo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Digite a quantidade de elementos: ");
        int quantidadeElementos = Integer.parseInt(console.nextLine());
    
        System.out.printf(
            "Digite o tipo de dado da Pilha:\n" +
            "[0] - Inteiro\n" +
            "[1] - Flutuante\n" +
            "[2] - Texto\n"
        );
    
        int tipoDado = Integer.parseInt(console.nextLine());
    
        switch (tipoDado) {
            case 0:
                exemploPilha(quantidadeElementos, Integer.class);
                break;
            case 1:
                exemploPilha(quantidadeElementos, Double.class);
                break;
            case 2:
                exemploPilha(quantidadeElementos, String.class);
                break;
            default:
                System.out.println("Não foi possível montar a pilha. Tipo de Dado inválido");
        }
    }
    
    /**
     * Método genérico responsável por fazer chamar as funções da pilha
     * 
     * @param <T> - Tipo genérico da pilha
     * @param quantidadeElementos - Quantidade de elementos que será inserido na pilha
     * @param tipo - Tipo de dado que será construído a pilha
     */
    public static <T> void exemploPilha(int quantidadeElementos, Class<T> tipo) {
        Pilha<T> minhaPilha = new Pilha<>();
        for (int i=0; i<quantidadeElementos; i++) {
            System.out.print("Digite o valor: ");
            if (tipo == Integer.class) {
                minhaPilha.empilhar(tipo.cast(Integer.parseInt(console.nextLine())));
            } 
            else if (tipo == Double.class) {
                minhaPilha.empilhar(tipo.cast(Double.parseDouble(console.nextLine())));
            } 
            else if (tipo == String.class) {
                minhaPilha.empilhar(tipo.cast(console.nextLine()));
            }
        }
        System.out.println();
    
        // Exemplo de operações
    
        System.out.println("Mostrando o topo:" + minhaPilha.getTopo() + "\n");
    
        System.out.println("Desempilhando 2 elementos!\n");
        minhaPilha.desempilhar();
        minhaPilha.desempilhar();
    
        System.out.println();
    
        minhaPilha.mostrarPilha();
    }
}
