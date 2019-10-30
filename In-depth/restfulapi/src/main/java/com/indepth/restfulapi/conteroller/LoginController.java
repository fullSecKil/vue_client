package com.indepth.restfulapi.conteroller;

import com.indepth.restfulapi.pojo.User;
import com.indepth.restfulapi.pojo.AjaxResponse;
import com.indepth.restfulapi.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public AjaxResponse login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String htmlEscape = HtmlUtils.htmlEscape(username);
        log.info("request message {}", htmlEscape);
        return userService.get(requestUser.getUsername(), requestUser.getPassword()).map(AjaxResponse::success)
                .orElse(AjaxResponse.failde(String.format("%s_用户未找到", htmlEscape)));
    }
}
