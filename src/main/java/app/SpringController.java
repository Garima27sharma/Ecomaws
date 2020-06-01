package app;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpringController {

    @RequestMapping(value = "/health",method = RequestMethod.GET,produces = "application/json")
    public String health() {
        return "{ \"status\": \"Application is up and running!\"}";
    }

}