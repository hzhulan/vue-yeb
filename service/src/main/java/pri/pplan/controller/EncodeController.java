package pri.pplan.controller;

import pri.pplan.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authod: pp_lan on 2021/10/26.
 */
@RestController
@RequestMapping("/code")
public class EncodeController {

    @RequestMapping("/aesDecode")
    public Response decode(String str) {
        return Response.ok(str);
    }
}
