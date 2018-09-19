import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        String input = urlToString("http://erdani.com/tdpl/hamlet.txt");
        input = input.toLowerCase();
        int wordCount = (input.length() - input.replaceAll("prince", "").length()) / "prince".length();

        System.out.printf("The word prince appears in Hamlet %d times", wordCount);

        /*
        ceate an arrayList called output
        loop over the input String, if the word is new, add to output.
        return output
         */
        System.out.println();
        System.out.println(uniqueWordCount(input));
    }

    public static int uniqueWordCount(String input) {
        input = input.replaceAll("[,.?!;]", "");
        ArrayList<String> output = new ArrayList<>();
        Scanner scan = new Scanner(input);

        while (scan.hasNext()) {
            String word = scan.next();
            //System.out.println(word);
            if (output.contains(word) == false) {
                output.add(word);
            }
        }
        return output.size();
    }
}
