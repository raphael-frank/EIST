package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {

    public int performSearch(List<Chapter> chapters, String chapterName) {
        for (Chapter chapter : chapters) {
            if (chapter.getName().equals(chapterName)) {
                return chapter.getPageNumber();
            }
        }

        return -1;
    }

}
