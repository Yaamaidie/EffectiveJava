package code.no45;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Overuse of streams - don't do this!
public class AnagramsUsingStreamHeavily {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI path = ClassLoader.getSystemClassLoader().getResource("code/no45/release_notes.txt").toURI();
        Path dictionary = Paths.get(path);
        int minGroupSize = 2;
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                    groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }
}