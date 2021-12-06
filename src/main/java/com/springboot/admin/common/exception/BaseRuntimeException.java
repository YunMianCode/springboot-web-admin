package com.springboot.admin.common.exception;


/**
 * 基础异常类
 */
public class BaseRuntimeException extends RuntimeException {
	public static final int RUNTIME_EXCEPTION = 10000000;

	private int code;

	private String message;


	public BaseRuntimeException() {
		super(ExceptionBundle.getMessage(String.valueOf(RUNTIME_EXCEPTION)));
		this.code = RUNTIME_EXCEPTION;
	}

	public BaseRuntimeException(int code) {
		this(code, ExceptionBundle.getMessage(String.valueOf(code)));
	}

	public BaseRuntimeException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public BaseRuntimeException(int code, Object[] args) {
		this(code, ExceptionBundle.getMessage(String.valueOf(code)), args);
	}

	public BaseRuntimeException(int code, String msgFormat, Object[] args) {
		super(String.format(msgFormat, args));
		this.code = code;
	}

	public BaseRuntimeException(int code, Throwable cause) {
		super(ExceptionBundle.getMessage(String.valueOf(code)), cause);
		this.code = code;
	}

	public BaseRuntimeException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
