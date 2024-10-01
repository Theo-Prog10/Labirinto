import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Entrada input = new Entrada();
        Labirinto lista = new Labirinto();
        lista.setLab(input.preencher());
        lista.setInicio(14,13);
        lista.solve();
    }
}