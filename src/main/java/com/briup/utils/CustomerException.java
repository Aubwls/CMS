package com.briup.utils;

/**
 * 自定义异常
 * @author 14151
 *
 */
public class CustomerException extends RuntimeException{
	private static final long serialVersionUID=1L;

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @param code
	 */
	public CustomerException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	
}
