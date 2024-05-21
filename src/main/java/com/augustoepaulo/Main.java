package com.augustoepaulo;

public class Main {
    public static void main(String[] args) {
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int capacity = 3; // Capacidade da memória

        // Instanciando os algoritmos de substituição de páginas
        FIFO fifo = new FIFO(capacity);
        LRU lru = new LRU(capacity);
        Clock clock = new Clock(capacity);
        Otimo otimo = new Otimo(capacity);

        // Executando os algoritmos
        fifo.pageReplacement(pages);
        lru.pageReplacement(pages);
        clock.pageReplacement(pages);
        otimo.pageReplacement(pages);

        // Exibindo os resultados
        System.out.println("FIFO - " + fifo.getPageFaults() + " faltas de página");
        System.out.println("LRU - " + lru.getPageFaults() + " faltas de página");
        System.out.println("Clock - " + clock.getPageFaults() + " faltas de página");
        System.out.println("Ótimo - " + otimo.getPageFaults() + " faltas de página");
    }
}