import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private ArrayList<ArrayList<Integer>> labirinto = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> inicio;

    Stack<Object> pilha = new Stack<>();
    
    public void solve() {
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

            if (prox.get(2) == 1) {
                pilha.push(aux);
                matriz[prox.get(0)][prox.get(1)] = 2;
            }
            else if (prox.get(2) == 2) {
                pilha.pop();
                matriz[prox.get(0)][prox.get(1)] = 0;
            }
            else if (prox.get(2) == 0) {
                continua = false;
                printaMatriz(matriz);
            }
            prox = redor(matriz,aux,false);
        }

    }

    public ArrayList<Integer> redor(int[][] matriz, ArrayList<Integer> coordenadas, boolean primeiro) {
        int x = coordenadas.get(0);
        int y = coordenadas.get(1);
        ArrayList<Integer> coord = new ArrayList<>();

        int valor;
        int[][][] direcoes = {
                {{-1, -1}, {-1, 0}, {-1, 1}},
                {{ 0, -1}, { 0, 0}, { 0, 1}},
                {{ 1, -1}, { 1, 0}, { 1, 1}}};

        break2lacos:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    valor = matriz[x+direcoes[i][j][0]][y+direcoes[i][j][1]];
                    if (valor == 1) {
                        coord.add(x+direcoes[i][j][0]);
                        coord.add(y+direcoes[i][j][1]);
                        coord.add(1);
                        return coord;
                    }
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    if (!primeiro) {
                        coordenadas.add(0);
                        return coordenadas;
                    }
//                    else {
//                        coordenadas.add(1);
//                        return coordenadas;
//                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                valor = matriz[x+direcoes[i][j][0]][y+direcoes[i][j][1]];
                if (valor == 2) {
                    coord.add(x+direcoes[i][j][0]);
                    coord.add(y+direcoes[i][j][1]);
                    coord.add(2);
                    return coord;
                }
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
