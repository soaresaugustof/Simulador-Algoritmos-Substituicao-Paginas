package com.augustoepaulo;

import java.util.ArrayList;
import java.util.List;

public class LRU {
    private List<Integer> frames;
    private int capacity;
    private int pageFaults;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.frames = new ArrayList<>();
        this.pageFaults = 0;
    }

    public void pageReplacement(int[] pages) {
        for (int page : pages) {
            if (!frames.contains(page)) {
                if (frames.size() == capacity) {
                    frames.remove(0); // Remove o menos recentemente usado, que é o primeiro elemento
                }
                frames.add(page); // Adiciona a nova página ao final da lista
                pageFaults++;
            } else {
                // Se a página já estiver na lista, move-a para o final (representando uso mais recente)
                frames.remove((Integer) page); // Remove a página do seu índice atual
                frames.add(page); // Adiciona a página novamente ao final da lista
            }
        }
    }

    public int getPageFaults() {
        return pageFaults;
    }
}
