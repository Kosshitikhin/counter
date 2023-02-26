package counter.services.impl;

import counter.services.FileCounterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DocxCounterServiceImpl implements FileCounterService {

    @Override
    public List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException {
        try (var files = Files.find(rootPath, maxDepthOfDirectory, (p, a) -> a.isRegularFile() && p.toString().endsWith(".docx"))) {
            return files.toList();
        }
    }
}
