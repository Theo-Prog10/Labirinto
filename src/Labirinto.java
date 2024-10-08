import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {

    static class Posicao{
        int x,y;

        public Posicao(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean posicaoValida(int[][] labirinto, boolean[][]visitado,int x, int y){
        return ( x>=0 && x < labirinto.length && y>=0 && y< labirinto[0].length && labirinto[x][y] == 1 & !visitado[x][y]);
    }

    public static Stack<?> solve(int[][]labirinto, Posicao inicio, Posicao fim){
        Stack<Posicao> pilha = new Stack<>();
        pilha.push(inicio);

        boolean[][] visistado = new boolean[labirinto.length][labirinto[0].length];
        visistado[inicio.x][inicio.y] = true;

        Posicao[][] caminho = new Posicao[labirinto.length][labirinto[0].length];

        int[] moviX = {-1,1,0,0,-1,-1,1,1};
        int[] moviY = {0,0,-1,1,-1,1,-1,1};

        Stack<Posicao> pilharetorno = new Stack<>();

        while(!pilha.isEmpty()){
            pilharetorno.push(pilha.peek());
            Posicao atual = pilha.pop();

            //Checando se chegou no fim
            if(atual.x == fim.x && atual.y == fim.y){
                Posicao pos = atual;
                while (pos!= null){
                    labirinto[pos.x][pos.y] = -1;
                    pos = caminho[pos.x][pos.y];
                }
                imprimirLab(labirinto);
                return pilharetorno;
            }
            //Andando pela matriz
            for (int i = 0; i < 8;i++){
                int novoX = atual.x + moviX[i];
                int novoY = atual.y + moviY[i];

                if(posicaoValida(labirinto,visistado,novoX,novoY)){
                    pilha.push(new Posicao(novoX,novoY));
                    visistado[novoX][novoY] = true;
                    caminho[novoX][novoY] = atual;
                }
            }
        }

        return null;
    }

    public static  void imprimirLab(int[][] labirinto) {
        for ( int i = 0; i < labirinto.length; i++){
            for ( int j = 0; j < labirinto[i].length; j++){
                if(labirinto[i][j] == -1) {
                    System.out.print("X ");
                } else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}


