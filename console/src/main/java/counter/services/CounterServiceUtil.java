package counter.services;

import counter.services.impl.DocxCounterServiceImpl;
import counter.services.impl.DocxPageCounterServiceImpl;
import counter.services.impl.PdfCounterServiceImpl;
import counter.services.impl.PdfPageCounterServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public abstract class CounterServiceUtil {

    public static final Map<FileCounterService, PageCounterService> serviceMap = new ConcurrentHashMap<>();

    static
    {
        serviceMap.put(new PdfCounterServiceImpl(), new PdfPageCounterServiceImpl());
        serviceMap.put(new DocxCounterServiceImpl(), new DocxPageCounterServiceImpl());
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
