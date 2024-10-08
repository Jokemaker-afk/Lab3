package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * This class provides the service of converting country codes to their names.
 */
public class CountryCodeConverter {

    // TODO Task: pick appropriate instance variable(s) to store the data necessary for this class
    private static Iterator<String> iterator;
    /**
     * Default constructor which will load the country codes from "country-codes.txt"
     * in the resources' folder.
     */

    public CountryCodeConverter() {
        this("country-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the country code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public CountryCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));
            iterator = lines.iterator();
            // TODO Task: use lines to populate the instance variable(s)

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the country for the given country code.
     * @param code the 3-letter code of the country
     * @return the name of the country corresponding to the code
     */
    // todo
    public String fromCountryCode(String code) {
        final int format = 4;

        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] nextList = next.split("\t", format);
            if (code.equalsIgnoreCase(nextList[2])) {
                return nextList[0];
            }
        }
        return null;
    }

    /**
     * Returns the code of the country for the given country name.
     * @param country the name of the country
     * @return the 3-letter code of the country
     */
    // todo
    public String fromCountry(String country) {
        final int format = 4;
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] nextList = next.split("\t", format);
            if (country.equalsIgnoreCase(nextList[0])) {
                return nextList[2];
            }
        }
        return null;
    }

    /**
     * Returns how many countries are included in this code converter.
     * @return how many countries are included in this code converter.
     */
    // todo
    public int getNumCountries() {
        int num = -1;
        while (iterator.hasNext()) {
            iterator.next();
            ++num;
        }
        return num;
    }
}
