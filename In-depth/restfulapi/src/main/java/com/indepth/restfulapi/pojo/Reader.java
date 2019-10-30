package com.indepth.restfulapi.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Reader
 *
 * @author dusk
 * @since 28/10/2019
 */
@NoArgsConstructor
@Data
public class Reader {

    public Reader(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @ExcelProperty(value = "姓名", index = 3)
    private String name;
    @ExcelProperty(value = "年龄", index = 6)
    private int age;
}
