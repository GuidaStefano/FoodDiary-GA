package it.unisa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CollectionUtil {

    public static <T> T getRandomElement(Set<T> set) {
        // Converti il Set in una List
        List<T> list = new ArrayList<>(set);

        // Crea un'istanza della classe Random
        Random random = new Random();

        // Seleziona un elemento casuale dalla List
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
