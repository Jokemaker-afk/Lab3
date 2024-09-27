package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * This class provides the service of converting language codes to their names.
 */
public class LanguageCodeConverter {

    // TODO Task: pick appropriate instance variables to store the data necessary for this class
    private static Iterator<String> iterator;
    private static String tab = "\t";
    /**
     * Default constructor which will load the language codes from "language-codes.txt"
     * in the resources folder.
     */

    public LanguageCodeConverter() {
        this("language-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the language code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public LanguageCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));
            iterator = lines.iterator();
            // TODO Task: use lines to populate the instance variable
            //           tip: you might find it convenient to create an iterator using lines.iterator()

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the language for the given language code.
     * @param code the language code
     * @return the name of the language corresponding to the code
     */
    // todo
    public String fromLanguageCode(String code) {
        iterator.next();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] nextList = next.split(tab, 2);
            if (Objects.equals(nextList[1], code)) {
                return nextList[0];
            }
        }
        return null;
    }

    /**
     * return the list for all language with two letters.
     * @return A list to help JSONTranslator.java
     */
    public List<String> getAlllanguage() {
        List<String> result = new ArrayList<>();
        iterator.next();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] nextList = next.split(tab, 2);
            result.add(nextList[1]);
        }
        return result;
    }

    /**
     * Returns the code of the language for the given language name.
     * @param language the name of the language
     * @return the 2-letter code of the language
     */
    // todo
    public String fromLanguage(String language) {
        iterator.next();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] nextList = next.split(tab, 2);
            if (language.equalsIgnoreCase(nextList[0])) {
                return nextList[1];
            }
        }
        return null;
    }

    /**
     * Returns how many languages are included in this code converter.
     * @return how many languages are included in this code converter.
     */
    // todo
    public int getNumLanguages() {
        int num = -1;
        // as for the first line is ISO like title
        while (iterator.hasNext()) {
            iterator.next();
            ++num;
        }
        return num;
    }
}
