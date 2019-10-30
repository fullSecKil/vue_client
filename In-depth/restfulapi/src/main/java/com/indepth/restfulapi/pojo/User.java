package com.indepth.restfulapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * User
 *
 * @author dusk
 * @since 28/10/2019
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 8673398970103300351L;
    @TableId(type = IdType.AUTO)
    Long id;
    String username;
    String password;
}
