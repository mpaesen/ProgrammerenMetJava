import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class FileAndDirectoryInfo
{
    public static void main(String[] args) throws IOException
    {
        List<String> extensionsList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name:");
        // create Path object based on user input
        Path path = Paths.get(input.nextLine());

        if (Files.exists(path))
        {
            if (Files.isDirectory(path)) {
                DirectoryStream<Path> directoryStream =Files.newDirectoryStream(path);

                for (Path p : directoryStream) {
                    String extension = FilenameUtils.getExtension(String.valueOf(p.getFileName()));
                    extensionsList.add(extension);
                }

                System.out.printf("%nFiletype | Count%n");
                long startTime = System.currentTimeMillis();
                extensionsList.stream()
                        .filter(ch -> !ch.isEmpty())
                        .collect(Collectors.groupingBy(e -> e,
                                TreeMap::new, Collectors.counting()))
                        .forEach((k, v) -> System.out.print(String.format("%-8s | %-10s\n",k, v)));
                long endTime = System.currentTimeMillis();
                System.out.println("Sequential execution time is " +
                        (endTime - startTime) + " milliseconds");

                System.out.printf("%nFiletype | Count%n");
                long startTime2 = System.currentTimeMillis();
                extensionsList.stream().parallel()
                        .filter(ch -> !ch.isEmpty())
                        .collect(Collectors.groupingBy(e -> e,
                                TreeMap::new, Collectors.counting()))
                        .forEach((k, v) -> System.out.print(String.format("%-8s | %-10s\n",k, v)));
                long endTime2 = System.currentTimeMillis();
                System.out.println("Parallel execution time is " +
                        (endTime2 - startTime2) + " milliseconds");
            }
        }
        else // not file or directory, output error message
        {
            System.out.printf("%s does not exist%n", path);
        }
    }
}
