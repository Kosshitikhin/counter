package counter.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface PageCounterService {

    int getCountPages(List<Path> filePaths) throws IOException;
}
