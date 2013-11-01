package cn.jsr.cloud.exception;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-11-1
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public class NoCityFoundException extends Exception {
    public NoCityFoundException(String message) {
        super(message);
    }
}
