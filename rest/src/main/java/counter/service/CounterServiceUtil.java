package counter.service;

import counter.service.impl.DocxService;
import counter.service.impl.PdfService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class CounterServiceUtil {

    public static final List<DocPageCounterService> docPageCounterServices = new ArrayList<>();

    static {
        docPageCounterServices.add(new DocxService());
        docPageCounterServices.add(new PdfService());
    }

    public static int getMaxDepthOfDirectory(Path rootPath) throws IOException {
        if (rootPath.toFile().isFile()) {
            return 1;
        }

        try (Stream<Path> files = Files.list(rootPath)){
            var paths = files.toList();

            var maxForThisNode = 0;

            for (var path : paths) {
                var intermediateValue = getMaxDepthOfDirectory(path);
                if (intermediateValue > maxForThisNode) {
                    maxForThisNode = intermediateValue;
                }
            }
            maxForThisNode++;
            return maxForThisNode;
        }
    }
}
