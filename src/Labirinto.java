import java.util.ArrayList;
import java.util.Stack;

public class Labirinto {
    private int[][] labirinto = null;
    private ArrayList<Integer> inicio;

    Stack<ArrayList<Integer>> pilha = new Stack<>();

    public void solve() {
        boolean[][] matriz_boolean = setMatrizBoolean();
        ArrayList<ArrayList<Integer>> historico = new ArrayList<>();

        try {
            if (matriz_boolean[this.inicio.get(0)][this.inicio.get(1)]) {
                pilha.push(this.inicio);
                historico.add(pilha.peek());
                matriz_boolean[this.inicio.get(0)][this.inicio.get(1)] = false;

                ArrayList<Integer> prox;
                prox = redor(matriz_boolean, pilha.peek(), true);
                while (prox != this.inicio) {
                    if (prox != null) {
                        pilha.push(prox);
                        historico.add(prox);
                        matriz_boolean[prox.get(0)][prox.get(1)] = false;
                    } else {
                        historico.add(pilha.pop());
                    }
                    prox = redor(matriz_boolean, historico.getLast(), false);
                }

                new Display(this.labirinto, inicio, historico);
            } else {
                System.out.println("Coordenadas (" + this.inicio.get(0) + "," + this.inicio.get(1) + ") inválidas pois representam uma parede.");
            }
        } catch (Exception e) {
            System.out.println("Coordenadas (" + this.inicio.get(0) + "," + this.inicio.get(1) + ") inválidas.");
            System.out.println("X deve ser <= " + (this.labirinto.length - 1) + " e Y deve ser <= " + (this.labirinto[0].length - 1) + ".");
        }
    }

    public ArrayList<Integer> redor(boolean[][] matriz, ArrayList<Integer> coordenadas, boolean primeiro) {
        int x = coordenadas.get(0);
        int y = coordenadas.get(1);
        ArrayList<Integer> coord = new ArrayList<>();

        boolean valor;
        int[] moviX = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] moviY = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            try {
                valor = matriz[x + moviX[i]][y + moviY[i]];
                if (valor) {
                    coord.add(x + moviX[i]);
                    coord.add(y + moviY[i]);
                    return coord;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                if (!primeiro) {
                    return this.inicio;
                }
            }
        }
        return null;
    }

    public boolean[][] setMatrizBoolean() {
        int i = 0;
        int j = 0;
        boolean[][] matriz = new boolean[labirinto.length][labirinto[0].length];
        for (int[] linha : labirinto) {
            for (int num : linha) {
                if (num == 1) {
                    matriz[i][j++] = true;
                } else {
                    matriz[i][j++] = false;
                }
            }
            i++;
            j = 0;
        }
        return matriz;
    }

    public void setLab(int[][] labirinto) {
        this.labirinto = labirinto;
    }

    public int[][] getLab() {
        return this.labirinto;
    }

    public void setInicio(int x, int y) {
        this.inicio = new ArrayList<>();
        this.inicio.add(x);
        this.inicio.add(y);
    }

    public void printaMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int anInt : linha) {
                if (anInt == 2) System.out.print("X ");
                else System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
