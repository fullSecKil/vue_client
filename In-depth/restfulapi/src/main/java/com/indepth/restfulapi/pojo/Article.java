package com.indepth.restfulapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Article
 *
 * @author dusk
 * @since 28/10/2019
 */
@Data
@JsonPropertyOrder(value = {"content", "title"})
public class Article {
    private Long id;
    @JsonProperty("auther")
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;
}
