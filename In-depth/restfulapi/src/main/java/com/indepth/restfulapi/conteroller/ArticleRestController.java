package com.indepth.restfulapi.conteroller;

import com.indepth.restfulapi.pojo.Article;
import com.indepth.restfulapi.pojo.AjaxResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * ArticleRestController
 *
 * @author dusk
 * @since 28/10/2019
 */
@Log4j2
@RestController
@RequestMapping(value = "/rest")
public class ArticleRestController {

    @PostMapping(value = "/article")
    // @ModelAttribute 和@RequestBody 区别  ModelAttribute用于表单或http路径，@RequestBody 用于postbody
    // https://blog.csdn.net/hpym365/article/details/56674437
    public AjaxResponse saveArticle(@ModelAttribute Article article, @RequestParam String author, @RequestParam String content) {
        log.info("saveArticle {}", article);
        return AjaxResponse.success(article);
    }

    @PostMapping(value = "/article2")
    //, @RequestHeader String requestHeader, @CookieValue String cookieValue
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle {}", article);
        return AjaxResponse.success(article);
    }
}
