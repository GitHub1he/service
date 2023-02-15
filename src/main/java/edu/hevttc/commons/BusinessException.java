package edu.hevttc.commons;

/**
 * @author Pc.dragon
 * @ClassName BussinesException
 * @description: zidingyi
 * @date 2023年02月10日
 * @version: 1.0
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -8624533394127244753L;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Exception ex) {
        super(ex);
        ex.printStackTrace();
    }
}
