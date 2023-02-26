package counter.service.impl;

import counter.service.PageCounterService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class DocxPageCounterServiceImpl implements PageCounterService {

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
