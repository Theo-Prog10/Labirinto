import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private ArrayList<ArrayList<Integer>> labirinto = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> inicio;

    Stack<Object> pilha = new Stack<>();
    int blabla;
    
    public void solve() {
        int[][] matriz = setMatriz();
        ArrayList<Integer> coordenadas;
        if (matriz[inicio.get(0)][inicio.get(1)] == 1) {
            coordenadas = new ArrayList<Integer>();
            coordenadas.add(inicio.get(0));
            coordenadas.add(inicio.get(1));
            pilha.push(coordenadas);
            matriz[inicio.get(0)][inicio.get(1)] = 2;
        }




    }

    public int[][] setMatriz() {
        int i = 0;
        int j = 0;
        int[][] matriz = new int[labirinto.size()][labirinto.getFirst().size()];
        for (ArrayList<Integer> linha : labirinto) {
            for (int num : linha) {
                matriz[i][j++] = num;
            }
            i++;
            j = 0;
        }
        return matriz;
    }

    public void setLab(ArrayList<ArrayList<Integer>> labirinto) {
        this.labirinto = labirinto;
    }
    public ArrayList<ArrayList<Integer>> getLab() {
        return this.labirinto;
    }

    public void setInicio(int x, int y) {
        this.inicio = new ArrayList<Integer>();
        this.inicio.add(x);
        this.inicio.add(y);
    }

    public void printaMatriz(int[][] matriz) {
        for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < matriz[k].length; l++) {
                System.out.print(matriz[k][l] + " ");
            }
            System.out.println();
        }
    }
}
