package com.indepth.restfulapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.indepth.restfulapi.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 *
 * @author dusk
 * @since 30/10/2019
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
