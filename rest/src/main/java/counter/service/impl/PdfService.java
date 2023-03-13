package counter.service.impl;

import counter.service.DocPageCounterService;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PdfService implements DocPageCounterService {

    @Override
    public List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException {
        try (var files = Files.find(rootPath, maxDepthOfDirectory, (p, a) -> a.isRegularFile() && p.toString().endsWith(".pdf"))) {
            return files.toList();
        }
    }

    @Override
    public int getCountPages(List<Path> filePaths) throws IOException {
        var pageCount = 0;

        for (var path : filePaths) {
            var document = PDDocument.load(path.toFile());
            pageCount += document.getNumberOfPages();
            document.close();
        }

        return pageCount;
    }
}
