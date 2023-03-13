package counter;

import counter.services.CounterServiceUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CounterApp {

    public static void main(String[] args) {

        var in = new Scanner(System.in);
        System.out.println("Введите адрес корневого каталога: ");
        var path = Path.of(in.nextLine());

        var documentCount = 0;
        var pageCount = 0;

        try {
            var maxDepth =  CounterServiceUtil.getMaxDepthOfDirectory(path);

            for (var service : CounterServiceUtil.docPageCounterServices) {
                var filePathList = service.getFilePaths(path, maxDepth);
                documentCount += filePathList.size();
                pageCount += service.getCountPages(filePathList);
            }
            System.out.println("Documents: " + documentCount);
            System.out.println("Pages: " + pageCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
