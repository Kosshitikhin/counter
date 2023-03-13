package counter.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DocPageCounterService {

    List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException;

    int getCountPages(List<Path> filePaths) throws IOException;
}
