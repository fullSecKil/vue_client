package com.indepth.restfulapi.conteroller;

import com.indepth.restfulapi.pojo.User;
import com.indepth.restfulapi.pojo.AjaxResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * LoginController
 *
 * @author dusk
 * @since 28/10/2019
 */
@Log4j2
@RestController
@RequestMapping(value = "api")
public class LoginController {

    @CrossOrigin
    @PostMapping("/login")
    public AjaxResponse login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String htmlEscape = HtmlUtils.htmlEscape(username);

        log.info("request message {}", htmlEscape);
        return AjaxResponse.success();
    }
}
