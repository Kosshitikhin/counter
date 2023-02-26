package counter.service;

import counter.RestCounterApp;
import counter.data.request.DirectoryDataRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestCounterApp.class)
public class CounterServiceTest {

    private static DirectoryDataRequest request;

    @Autowired
    private CounterService service;

    @Before
    public void prepare() {
        request = new DirectoryDataRequest();
    }

    @Test
    public void getDataOfDirectory() {

        //подставить свои данные для теста
        request.setRootPath("C:\\ecm");
        var expectedDocCount = 7;
        var expectedPageSum = 351;

        var actualData =  service.getDataOfDirectory(request);
        Assert.assertEquals(expectedDocCount, actualData.getDocumentCount());
        Assert.assertEquals(expectedPageSum, actualData.getPageSum());
    }
}