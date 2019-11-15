package com.luxondata.transferscaffold.pojo;

import lombok.Data;

/**
 * ResponseContent
 *
 * @author dusk
 * @since 28/10/2019
 */
@Data
public class ResponseContent {

    private boolean isok;   //请求是否处理成功
    private int code;          //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data;  //请求结果数据

    private ResponseContent() {

    }

    public static ResponseContent success() {
        ResponseContent resultBean = new ResponseContent();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static ResponseContent success(Object data) {
        ResponseContent resultBean = new ResponseContent();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

    public static ResponseContent failde(Object data) {
        ResponseContent resultBean = new ResponseContent();
        resultBean.setIsok(false);
        resultBean.setCode(400);
        resultBean.setMessage("failde");
        resultBean.setData(data);
        return resultBean;
    }

}
