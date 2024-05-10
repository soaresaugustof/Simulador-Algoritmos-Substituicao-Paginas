package com.augustoepaulo;

import java.util.ArrayList;
import java.util.List;

public class Otimo {
    private List<Integer> frames;
    private int capacity;
    private int pageFaults;

    public Otimo(int capacity) {
        this.capacity = capacity;
        this.frames = new ArrayList<>();
        this.pageFaults = 0;
    }

    public void pageReplacement(int[] pages) {
        for (int i = 0; i < pages.length; i++) {
            if (!frames.contains(pages[i])) {
                if (frames.size() < capacity) {
                    frames.add(pages[i]);
                } else {
                    int farthestIndex = i;
                    int replaceIndex = -1;
                    for (int j = 0; j < frames.size(); j++) {
                        int nextIndex = findNextOccurrence(pages, i, frames.get(j));
                        if (nextIndex == -1) {
                            replaceIndex = j;
                            break;
                        } else if (nextIndex > farthestIndex) {
                            farthestIndex = nextIndex;
                            replaceIndex = j;
                        }
                    }
                    frames.set(replaceIndex, pages[i]);
                }
                pageFaults++;
            }
        }
    }

    private int findNextOccurrence(int[] pages, int startIndex, int value) {
        for (int i = startIndex + 1; i < pages.length; i++) {
            if (pages[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int getPageFaults() {
        return pageFaults;
    }
}