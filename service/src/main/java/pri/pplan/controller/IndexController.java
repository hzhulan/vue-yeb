package  pri.pplan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pri.pplan.model.Response;

/**
 * @authod: pp_lan on 2020/7/11.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public Response index() {
        return Response.ok("index");
    }
}
