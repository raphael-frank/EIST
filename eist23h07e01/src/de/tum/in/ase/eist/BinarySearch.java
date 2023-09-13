package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {

    public int performSearch(List<Chapter> chapters, String chapterName) {
        int l = 0;
        int r = chapters.size() - 1;

        while (true) {
            if (l > r) {
                return -1;
            }

            int mid = l + (r - l) / 2;
            String curName = chapters.get(mid).getName();

            int compareValue = curName.compareTo(chapterName);

            if (compareValue < 0) {
                l = mid + 1;
            } else if (compareValue == 0) {
                return chapters.get(mid).getPageNumber();
            } else { // > 0
                r = mid - 1;
            }
        }
    }

}
