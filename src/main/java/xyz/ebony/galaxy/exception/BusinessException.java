package xyz.ebony.galaxy.exception;


public class BusinessException extends RuntimeException {

  private String code;
  private Object data;

  public BusinessException(String msg) {
    this(null, msg);
  }

  public BusinessException(String code, String msg) {
    this(code, msg, null);
  }

  public BusinessException(String code, String msg, Object data) {
    super(msg);
    this.code = code;
    this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static void throwBusinessException(String msg) {
    throwBusinessException(null, msg);
  }

  public static void throwBusinessException(String code, String msg) {
    throwBusinessException(code, msg, null);
  }

  public static void throwBusinessException(String code, String msg, Object data) {
    throw new BusinessException(code, msg, data);
  }
}

