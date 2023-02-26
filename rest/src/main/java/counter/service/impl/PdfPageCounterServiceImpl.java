package counter.service.impl;

import counter.service.PageCounterService;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
