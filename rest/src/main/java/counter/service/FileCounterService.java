package counter.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileCounterService {

    List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException;

}
