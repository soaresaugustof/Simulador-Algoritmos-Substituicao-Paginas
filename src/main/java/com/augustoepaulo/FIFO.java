package com.augustoepaulo;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
    private List<Integer> frames;
    private int capacity;
    private int pageFaults;

    public FIFO(int capacity) {
        this.capacity = capacity;
        this.frames = new ArrayList<>();
        this.pageFaults = 0;
    }

    public void pageReplacement(int[] pages) {
        for (int page : pages) {
            if (!frames.contains(page)) {
                if (frames.size() == capacity) {
                    frames.remove(0); // Remove o primeiro elemento, que é o mais antigo
                }
                frames.add(page); // Adiciona a nova página ao final da lista
                pageFaults++;
            }
        }
    }

    public int getPageFaults() {
        return pageFaults;
    }
}