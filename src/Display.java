import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Display extends JFrame {
    private final int[][] labirinto;
    private final JPanel[][] cells;
    private int playerRow, playerCol;

    public Display(int[][] labirinto, ArrayList<Integer> inicio, ArrayList<ArrayList<Integer>> historico) throws InterruptedException {
        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        initUI(inicio);
        iniciarAnimacao(historico);
    }

    private void initUI(ArrayList<Integer> inicio) {
        // Configuração da janela e layout
        setTitle("Labirinto com Animação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(labirinto.length, labirinto[0].length));

        // Inicializa o labirinto gráfico
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                cells[i][j] = new JPanel();
                if (labirinto[i][j] == 0) {
                    cells[i][j].setBackground(Color.BLACK); // Paredes são pretas
                } else {
                    cells[i][j].setBackground(Color.WHITE); // Passagens são brancas
                }
                add(cells[i][j]);
            }
        }
        playerRow = inicio.get(0);
        playerCol = inicio.get(1);
        cells[playerRow][playerCol].setBackground(Color.RED); // Cor do "jogador"
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarAnimacao(ArrayList<ArrayList<Integer>> historico) throws InterruptedException {
        // Cria um timer que move o "jogador" a cada 500 milissegundos
        for (ArrayList<Integer> posicao : historico) {
            moverJogador(posicao);
            TimeUnit.MILLISECONDS.sleep(20);
        }
    }

    private void moverJogador(ArrayList<Integer> posicao) {
        // Remove o jogador da posição atual
        cells[playerRow][playerCol].setBackground(Color.WHITE);

        // Move o jogador para a nova posição
        playerRow = posicao.get(0);
        playerCol = posicao.get(1);
        cells[playerRow][playerCol].setBackground(Color.RED);
    }
}