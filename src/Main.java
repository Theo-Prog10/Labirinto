import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Entrada input = new Entrada();
        Labirinto lista = new Labirinto();
        lista.setLab(input.preencher());
        lista.setInicio(16,1);
        lista.solve();

    }
}