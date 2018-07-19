package code.no46;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class DD {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Proper use of streams to initialize a frequency table
        Stream<String> words = tokens().stream();
        Map<String, Long> freq = words
                .collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(freq);

        //print top ten list from frequency table
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());
        System.out.println(topTen);
    }

    private static List<String> tokens() throws URISyntaxException, IOException {
        URI path = ClassLoader.getSystemClassLoader().getResource("code/no45/release_notes.txt").toURI();
        List<String> tokens = new ArrayList<>();
        try (Scanner in = new Scanner(Paths.get(path))) {
            while (in.hasNext()) {
                tokens.add(in.next());
            }
        }
        return tokens;
    }
}
