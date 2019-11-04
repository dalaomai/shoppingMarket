package cn.small.pig.entity;

import java.io.Serializable;

/**
 * @author dalaomai
 *
 */
public class OperateResult implements Serializable {
	private boolean success;
	private String message;
	
	public OperateResult() {
		
	}
	
	public OperateResult(boolean success,String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
