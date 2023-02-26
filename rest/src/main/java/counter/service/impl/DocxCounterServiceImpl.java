package counter.service.impl;


import counter.service.FileCounterService;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
