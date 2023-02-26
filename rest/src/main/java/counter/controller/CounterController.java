package counter.controller;

import counter.data.DirectoryData;
import counter.data.request.DirectoryDataRequest;
import counter.service.CounterService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("general/contains")
    public DirectoryData getDataOfDirectory(@Valid @RequestBody DirectoryDataRequest request) {
        return  counterService.getDataOfDirectory(request);
    }
}
