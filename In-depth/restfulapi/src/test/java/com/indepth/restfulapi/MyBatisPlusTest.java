package com.indepth.restfulapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.indepth.restfulapi.mapper.UserMapper;
import com.indepth.restfulapi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MyBatisPlusTest
 *
 * @author dusk
 * @since 30/10/2019
 */

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectOne() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("微笑");
        user.setPassword("dk");
//        Assert.isAssignable(userMapper.insert(user));
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(user);
        }
        assertThat(userMapper.insert(user)).isGreaterThan(0);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void testDelete() {
        assertThat(userMapper.deleteById(3L)).isGreaterThan(0);
        // QueryWrapper 是 MyBatis-Plus 内部辅助查询类 批量删除
        assertThat(userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getUsername, "微笑")))
                .isGreaterThan(0);
    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectById(2L);

        assertThat(user.getUsername()).isEqualTo("dingzhiwei");
        assertThat(user.getPassword()).isEqualTo("weizhid");

        userMapper.update(null, Wrappers.<User>lambdaUpdate().set(User::getUsername, "zzz").eq(User::getId, 2L));
        assertThat(userMapper.selectById(2L).getUsername()).isEqualTo("zzz");
//        userMapper.update();
    }

    @Test
    void testSelect() {
        List<User> userList = userMapper.selectList(null);

        assertThat(userList.size()).isEqualTo(3);
        userList.forEach(System.out::println);
    }

    @Test
    void testPage() {
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>().gt("id", 6L));

        assertThat(page).isSameAs(userIPage);

        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        System.out.println("当前分页总页数 ------>" + userIPage.getPages());
        System.out.println(userIPage.getRecords());
    }
}
