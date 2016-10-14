package com.jwc.aiya.bean;

/**
 * 结果返回类
 * @param <T>
 */
public class Result<T> {
	public static final int STATE_SUC = 0;
	public static final int STATE_FAIL = 1;
	
	public String describe;
	
	public int state;
	
	public T data;

}
