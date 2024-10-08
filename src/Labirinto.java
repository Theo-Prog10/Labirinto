import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private ArrayList<ArrayList<Integer>> labirinto = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> inicio;

    Stack<Object> pilha = new Stack<>();
    
    public void solve() throws InterruptedException {
        int[][] matriz = setMatriz();
        ArrayList<Integer> coordenadas = new ArrayList<Integer>();

        //primeiro push
        if (matriz[inicio.get(0)][inicio.get(1)] == 1) {
            coordenadas = new ArrayList<Integer>();
            coordenadas.add(inicio.get(0));
            coordenadas.add(inicio.get(1));
            pilha.push(coordenadas);
            matriz[inicio.get(0)][inicio.get(1)] = 2;
        }

        ArrayList<Integer> prox;
        prox = redor(matriz,coordenadas,true);
        ArrayList<Integer> aux;
        boolean continua = true;
        while (continua) {
            aux = new ArrayList<>();
            aux.add(prox.get(0));
            aux.add(prox.get(1));
            pilha.push(aux);

            if (prox.get(2) == 1) {
                matriz[prox.get(0)][prox.get(1)] = 2;
            }
            else if (prox.get(2) == 2) {
                matriz[prox.get(0)][prox.get(1)] = 3;
            }
            else if (prox.get(2) == 0) {
                continua = false;
                printaMatriz(matriz);
            }
            prox = redor(matriz,aux,false);
        }

        Display display = new Display(matriz,inicio,pilha);
    }

    public ArrayList<Integer> redor(int[][] matriz, ArrayList<Integer> coordenadas, boolean primeiro) {
        int x = coordenadas.get(0);
        int y = coordenadas.get(1);
        ArrayList<Integer> coord = new ArrayList<>();

        int valor;
        int[] moviX = {-1,1,0,0,-1,-1,1,1};
        int[] moviY = {0,0,-1,1,-1,1,-1,1};


        for (int i = 0; i < 8; i++) {
            try {
                valor = matriz[x+moviX[i]][y+moviY[i]];
                if (valor == 1) {
                    coord.add(x+moviX[i]);
                    coord.add(y+moviY[i]);
                    coord.add(1);
                    return coord;
                }
            }
            catch(ArrayIndexOutOfBoundsException exception) {
                if (!primeiro) {
                    coordenadas.add(0);
                    return coordenadas;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            valor = matriz[x+moviX[i]][y+moviY[i]];
            if (valor == 2) {
                coord.add(x+moviX[i]);
                coord.add(y+moviY[i]);
                coord.add(2);
                matriz[x][y] = 3;
                return coord;
            }
        }
        coordenadas.add(0);
        return coordenadas;
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
                if (matriz[k][l] == 2) System.out.print("X ");
                else System.out.print(matriz[k][l] + " ");
            }
            System.out.println();
        }
    }
}
