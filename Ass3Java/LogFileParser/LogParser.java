import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LogParser {

    // Valid log types
    private static final Set<String> VALID_LOG_TYPES =
            new HashSet<>(Arrays.asList(
                    "error",
                    "warning",
                    "info",
                    "debug"
            ));

    public static void main(String[] args) {

        try {

            // Default values
            String filePath;
            int numberOfLines = 10;

            Set<String> logTypes = new HashSet<>();
            logTypes.add("error");

            // Minimum one argument required
            if (args.length < 1) {

                throw new IllegalArgumentException(
                        "Usage: java LogParser <file-path> [number-of-lines] [log-types]"
                );
            }

            // File path
            filePath = args[0];

            // Optional number of lines
            if (args.length >= 2) {

                numberOfLines = Integer.parseInt(args[1]);
            }

            // Optional log types
            if (args.length >= 3) {

                logTypes.clear();

                String[] types = args[2].split(",");

                for (String type : types) {

                    type = type.trim().toLowerCase();

                    // Validate type
                    if (!VALID_LOG_TYPES.contains(type)) {

                        throw new IllegalArgumentException(
                                "Invalid log type: " + type
                        );
                    }

                    logTypes.add(type);
                }
            }

            parseLogFile(filePath, numberOfLines, logTypes);

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void parseLogFile(
            String filePath,
            int numberOfLines,
            Set<String> logTypes
    ) throws Exception {

        Path path = Paths.get(filePath);

        // Validate file path
        if (!Files.exists(path)) {

            throw new FileNotFoundException(
                    "Invalid file path."
            );
        }

        // Read all lines
        List<String> allLines = Files.readAllLines(path);

        List<String> matchedLogs = new ArrayList<>();

        // Start parsing from end
        for (int i = allLines.size() - 1; i >= 0; i--) {

            String line = allLines.get(i);

            String lowerLine = line.toLowerCase();

            for (String type : logTypes) {

                if (lowerLine.startsWith("[" + type + "]")) {

                    matchedLogs.add(line);
                    break;
                }
            }

            // Stop after required count
            if (matchedLogs.size() == numberOfLines) {

                break;
            }
        }

        // Display result
        System.out.println("\n===== FILTERED LOGS =====\n");

        for (String log : matchedLogs) {

            System.out.println(log);
        }
    }
}