package edu.hevttc.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pc.dragon
 * @ClassName ExceptionAdvice
 * @description: 控制增强器
 * @date 2023年02月10日
 * @version: 1.0
 */

@RestController
@ControllerAdvice
//@ControllerAdvice(控制器增强。该注解可以把其声明的类中使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法)声明一个拦截全局异常的@ExceptionHandler
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class) //@ExceptionHandler拦截相应异常
    @ResponseBody
    public ReturnObject handleException(Exception e) {
        ReturnObject result = new ReturnObject();
        result.setCode(1);
        result.setMsg(e.getMessage());
        return result;
    }
}
