package app;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import DataBasePack.ConnectToDb;

@RestController
public class SpringController {

    @RequestMapping(value = "/health",method = RequestMethod.GET,produces = "application/json")
    public String health() {
        return "{ \"status\": \"Application is up and running!\"}";
    }

    @RequestMapping(value = "/search/{productId}",method = RequestMethod.GET,produces = "application/json")
    public String searchById(@PathVariable("productId") String productId)
     {
        return productId;
    }








}