import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Display extends JFrame {
    private int[][] labirinto;
    private JPanel[][] cells;
    private int playerRow, playerCol;

    public Display(int[][] labirinto, Labirinto.Posicao posicao, Stack<?> pilha) throws InterruptedException {
        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        initUI(posicao);
        iniciarAnimacao(pilha);
    }

    private void initUI(Labirinto.Posicao posicao) {
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
        playerRow = posicao.x;
        playerCol = posicao.y;
        cells[playerRow][playerCol].setBackground(Color.RED); // Cor do "jogador"
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarAnimacao(Stack pilha) throws InterruptedException {
        // Cria um timer que move o "jogador" a cada 500 milissegundos
        for (Object posicao : pilha) {
            moverJogador((Labirinto.Posicao) posicao);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    private void moverJogador(Labirinto.Posicao posicao) {
        // Escolhe uma direção aleatória: 0 = cima, 1 = baixo, 2 = esquerda, 3 = direita
//        int direcao = random.nextInt(4);
        int novaLinha = playerRow;
        int novaColuna = playerCol;
//
//        switch (direcao) {
//            case 0: // Cima
//                novaLinha = playerRow - 1;
//                break;
//            case 1: // Baixo
//                novaLinha = playerRow + 1;
//                break;
//            case 2: // Esquerda
//                novaColuna = playerCol - 1;
//                break;
//            case 3: // Direita
//                novaColuna = playerCol + 1;
//                break;
//        }
//
//        // Verifica se a nova posição está dentro dos limites e se não é uma parede
//        if (novaLinha >= 0 && novaLinha < labirinto.length &&
//            novaColuna >= 0 && novaColuna < labirinto[0].length &&
//            labirinto[novaLinha][novaColuna] == 1) {

            // Remove o jogador da posição atual
            cells[playerRow][playerCol].setBackground(Color.WHITE);

            // Move o jogador para a nova posição
            playerRow = posicao.x;
            playerCol = posicao.y;
            cells[playerRow][playerCol].setBackground(Color.RED);
//        }
    }
}

