package counter.service.impl;

import counter.service.DocPageCounterService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DocxService implements DocPageCounterService {


    @Override
    public List<Path> getFilePaths(Path rootPath, int maxDepthOfDirectory) throws IOException {
        try (var files = Files.find(rootPath, maxDepthOfDirectory, (p, a) -> a.isRegularFile() && p.toString().endsWith(".docx"))) {
            return files.toList();
        }
    }

    @Override
    public int getCountPages(List<Path> filePaths) throws IOException {
        var pageCount = 0;

        for (var path : filePaths) {
            var document = new XWPFDocument(new FileInputStream(path.toFile()));
            pageCount += document.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
            document.close();
        }

        return pageCount;
    }


}
