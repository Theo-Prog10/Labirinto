public class Main {
    public static void main(String[] args) {
        Entrada input = new Entrada("labirinto 1.csv");
        Labirinto lista = new Labirinto();
        lista.setLab(input.preencher());
        lista.setInicio(17, 1); //labirinto 1.csv
        //lista.setInicio(100, 63); //labirinto 2.csv
        lista.solve();
    }
}