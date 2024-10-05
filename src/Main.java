import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Entrada entrada = new Entrada();
        ArrayList<ArrayList<Integer>> labirintoList = entrada.preencher();

        //Convertendo o ArrayList para uma matriz
        int linhas = labirintoList.size();
        int colunas = labirintoList.get(0).size();
        int[][] labirinto = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                labirinto[i][j] = labirintoList.get(i).get(j);
            }
        }


        Labirinto.Posicao inicio = new Labirinto.Posicao(14, 13); // Início do labirinto
        Labirinto.Posicao fim = new Labirinto.Posicao(9, 0);    // Fim do labirinto

        if (Labirinto.solve(labirinto, inicio, fim)) {
            System.out.println("Caminho encontrado!");
        } else {
            System.out.println("Caminho não encontrado.");
        }
    }
}