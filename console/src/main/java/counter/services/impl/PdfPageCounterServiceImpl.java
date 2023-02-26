package counter.services.impl;

import counter.services.PageCounterService;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class PdfPageCounterServiceImpl implements PageCounterService {

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
