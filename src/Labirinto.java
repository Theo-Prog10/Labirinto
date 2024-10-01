import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private ArrayList<ArrayList<Integer>> labirinto = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> inicio;

    Stack<Object> pilha = new Stack<>();
    
    public void solve() {
        int[][] matriz = setMatriz();
        ArrayList<Integer> coordenadas;

        //primeiro push
        if (matriz[inicio.get(0)][inicio.get(1)] == 1) {
            coordenadas = new ArrayList<Integer>();
            coordenadas.add(inicio.get(0));
            coordenadas.add(inicio.get(1));
            pilha.push(coordenadas);
            matriz[inicio.get(0)][inicio.get(1)] = 2;
            redor(matriz,coordenadas);
        }

        //while (coordenadas != this.inicio && )

    }

    public ArrayList<Integer> redor(int[][] matriz, ArrayList<Integer> coordenadas) {
        int x = coordenadas.get(0);
        int y = coordenadas.get(1);
        ArrayList<Integer> coord = new ArrayList<>();

        int valor;
        int[][][] direcoes = {
                {{-1, -1}, {-1, 0}, {-1, 0}},
                {{ 0, -1}, { x, y}, { 0, 1}},
                {{ 1, -1}, { 1, 0}, { 1, 1}}};

        break2lacos:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println();
                try {
                    valor = matriz[x+direcoes[i][j][0]][y+direcoes[i][j][1]];
                    if (valor == 1) {
                        coord.add(x+direcoes[i][j][0]);
                        coord.add(y+direcoes[i][j][1]);
                        break break2lacos;
                    }
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    System.out.println("coordenadas não existem");
                }
            }
        }
        return coord;
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
