package app;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import DataBasePack.ConnectToDb;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class SpringController {

    ConnectToDb cdb=new ConnectToDb();
    @RequestMapping(value = "/health",method = RequestMethod.GET,produces = "application/json")
    public String health() {
        return "{ \"status\": \"Application is up and running!\"}";
    }

    @RequestMapping(value = "/search/{productId}",method = RequestMethod.GET,produces = "application/json")
    public String searchById(@PathVariable("productId") String productId)
     {
        return cdb.readById(new ArrayList<String>(Arrays.asList(productId)));

    }


  @RequestMapping(value = "/searchByName/{name}",method = RequestMethod.GET,produces = "application/json")
    public String findbyName(@PathVariable(value="name") String name)
    {
        return name;
    }






}