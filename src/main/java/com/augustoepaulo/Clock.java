package com.augustoepaulo;

import java.util.ArrayList;
import java.util.List;

public class Clock {
    private List<Integer> frames;
    private List<Boolean> referenced;
    private int capacity;
    private int pageFaults;
    private int clockHand;

    public Clock(int capacity) {
        this.capacity = capacity;
        this.frames = new ArrayList<>(capacity);
        this.referenced = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            frames.add(null);
            referenced.add(false);
        }
        this.pageFaults = 0;
        this.clockHand = 0;
    }

    public void pageReplacement(int[] pages) {
        for (int page : pages) {
            if (!frames.contains(page)) {
                while (referenced.get(clockHand)) {
                    referenced.set(clockHand, false);
                    clockHand = (clockHand + 1) % capacity;
                }
                frames.set(clockHand, page);
                referenced.set(clockHand, true);
                clockHand = (clockHand + 1) % capacity;
                pageFaults++;
            }
        }
    }

    public int getPageFaults() {
        return pageFaults;
    }
}