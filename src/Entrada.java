import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     *
     * @author Hilario Seibel Junior e Eduardo Pitanga Loureiro e Theo Mischiatti Gomes
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("labirinto - Página1.csv"));
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     *
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        System.out.print(msg);
        String linha;
        do {
            try {
                linha = input.nextLine();
            } catch (NoSuchElementException e) {
                return ""; // Ou outra ação apropriada
            }
        } while (linha.startsWith("#"));
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     *
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        int linha = 0;
        boolean continua = true;
        while (continua) {
            try {
                linha = Integer.parseInt(this.lerLinha(msg));
                continua = false;
            } catch (NumberFormatException e) {
                System.err.println("Input inválido, digite um NÚMERO");
            }
        }
        return linha;
    }

    public ArrayList<ArrayList<Integer>> preencher(){
        ArrayList<ArrayList<Integer>> lab = new ArrayList<>();
        String linha = this.lerLinha("");
        while (!Objects.equals(linha, "")) {
            String[] words = linha.split(",");
            ArrayList<Integer> aux = new ArrayList<Integer>();
            for (String num : words) {
                int numaux = Integer.parseInt(num);
                aux.add(numaux);
            }
            lab.add(aux);
            linha = this.lerLinha("");
            //linha = this.lerLinha("linha: ");
        }
    return lab;
    }

    public static void printNestedList(ArrayList<ArrayList<Integer>> nestedList) {
        int primeiro = 0;
        for (ArrayList<Integer> innerList : nestedList) {
            if (primeiro == 1) System.out.println();
            for (int num : innerList) {
                System.out.printf(num + " ");
                primeiro = 1;
            }
        }
    }
}