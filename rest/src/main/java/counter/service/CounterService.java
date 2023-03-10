package counter.service;

import counter.data.DirectoryData;
import counter.data.request.DirectoryDataRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class CounterService {

    public DirectoryData getDataOfDirectory(DirectoryDataRequest request) {
        var path = Path.of(request.getRootPath());
        var documentCount = 0;
        var pageCount = 0;

        try {
            var maxDepth =  CounterServiceUtil.getMaxDepthOfDirectory(path);

            for (var service : CounterServiceUtil.docPageCounterServices) {
                var filePathList = service.getFilePaths(path, maxDepth);
                documentCount += filePathList.size();
                pageCount += service.getCountPages(filePathList);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new DirectoryData(documentCount, pageCount);
    }
}
