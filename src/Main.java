import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Entrada input = new Entrada();
        Labirinto lista = new Labirinto();
        lista.setLab(input.preencher());
        Entrada.printNestedList(lista.getLab());
        lista.setInicio(0,0);
        lista.solve();
    }
}