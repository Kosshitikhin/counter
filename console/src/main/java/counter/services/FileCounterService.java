package counter.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileCounterService {

    List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException;

    default int getMaxDepthOfDirectory(Path rootPath) throws IOException {
        if (rootPath.toFile().isFile()) {
            return 1;
        }

        try (Stream<Path> files = Files.list(rootPath)){
            var paths = files.toList();

            var maxForThisNode = 0;

            for (var path : paths) {
                var intermediateValue = getMaxDepthOfDirectory(path);
                if (intermediateValue > maxForThisNode) {
                    maxForThisNode = intermediateValue;
                }
            }
            maxForThisNode++;
            return maxForThisNode;
        }
    }
}
