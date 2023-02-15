package edu.hevttc.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 统一JSON返回值封装对象
 */
@Builder
public class ReturnObject<T> {
    /**
     * 响应状态码 例如 0 表示请求成功    1 表示请求失败
     * 如果状态码比较可以将状态定义到一个常量类中或在当前类中定义静态常量数据
     * 或使用枚举类型
     */
    private int code;
    /**
     * 响应信息可以包含成功或失败的信息提示
     */
    private String  msg;
    /**
     * 具体的响应数据，类型为泛型类型
     */
    private T result;

    public static ReturnObject SUCCESS(){
        return new ReturnObject(0,"请求成功",null);
    }
    public static ReturnObject SUCCESS(Object result){
        return new ReturnObject(0,"请求成功",result);
    }
    public static ReturnObject SUCCESS(String msg,Object result){
        return new ReturnObject(0,"请求成功",result);
    }

    public static ReturnObject SUCCESS(String msg){
        return new ReturnObject(0,msg,null);
    }

    public static ReturnObject ERROR(){
        return new ReturnObject(1,"请求失败",null);
    }
    public static ReturnObject ERROR(String msg){
        return new ReturnObject(1,msg,null);
    }


    public ReturnObject() {
    }

    public ReturnObject(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
