package pri.pplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pri.pplan.model.Response;

/**
 * @authod: pp_lan on 2021/11/25.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/login")
    public Response login() {


        return Response.ok("");
    }
}
