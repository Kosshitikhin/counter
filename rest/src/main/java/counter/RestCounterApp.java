package counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
})
public class RestCounterApp {
    public static void main(String[] args) {
        SpringApplication.run(RestCounterApp.class, args);
    }
}