package  pri.pplan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pri.pplan.model.Response;

import java.util.HashMap;

/**
 * @authod: pp_lan on 2020/7/11.
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public Response index() {
        return Response.ok("index");
    }

    @RequestMapping(value = "/img", method = {RequestMethod.GET, RequestMethod.POST})
    public Response img() {
        HashMap<String, String> result = new HashMap<>();
        result.put("img", "img/verify.jpg");
        result.put("value", "200");
        return Response.ok(result);
    }

}
