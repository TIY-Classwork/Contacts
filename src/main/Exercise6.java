package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jack on 10/28/15.
 */
public class Exercise6 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList(Arrays.asList("alice", "bob", "charlie", "david", "allen", "barbie", "colin", "dan"));

        // Take the first 5 (in one command, look at Java Doc)
        names = new ArrayList(names.subList(0, 5));

        solveviaStream(names);
        solveViaTempLists(names);
        solveViaDirectModification(names);
    }


    static void solveViaDirectModification(ArrayList<String> names) {
        // Make every string inside uppercase
        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i).toUpperCase();
            names.set(i, s);
        }

        // Remove the ones that start with "A"
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String name = it.next();
            if (name.startsWith("A")) {
                it.remove();
            }
        }

        System.out.println(names);
    }

    static void solveViaTempLists(ArrayList<String> names) {
        // Make every string inside uppercase
        ArrayList<String> tempNames = new ArrayList();
        for (String name : names) {
            tempNames.add(name.toUpperCase());
        }
        names = tempNames;

        // Remove the ones that start with "A"
        tempNames = new ArrayList();
        for (String name : names) {
            if (!name.startsWith("A")) {
                tempNames.add(name);
            }
        }
        names = tempNames;

        System.out.println(names);
    }

    static void solveviaStream(ArrayList<String> names) {
        List<String> newNames =
                names
                .stream()
                .map((name) -> {
                    return name.toUpperCase();
                })
                .filter((name) -> {
                    return !name.startsWith("A");
                })
                .collect(Collectors.toList());

        System.out.println(newNames);
    }
}
