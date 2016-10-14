package com.jwc.aiya.bean;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable{

	/**
	 * 用户id
	 */
	protected Long uid = null;

	/**
	 * 用户名
	 */
	protected String username = null;
	
	/**
	 * 密码
	 */
	protected String password = null;
	
	/**
	 * 昵称
	 */
	protected String nickname = null;
	
	/**
	 * 唯一标识
	 */
	protected String token = null;
	
	/**
	 * 唯一标识创建时间
	 */
	protected String tokenCreateAt = null;
	
	/**
	 * 邮箱
	 */
	protected String email = null;
	
	/**
	 * 手机号
	 */
	protected String phoneNum = null;
	
	/**
	 * 性别
	 */
	protected Integer sex = null;
	
	/**
	 * 头像地址
	 */
	protected String photoUrl = null;
	
	/**
	 * 账号创建时间
	 */
	protected String accountCraeteAt = null;
	
	/**
	 * 最后一次登陆时间
	 */
	protected String lastLogin = null;
	
	/**
	 * 个人说明
	 */
	protected String explan = null;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenCreateAt() {
		return tokenCreateAt;
	}

	public void setTokenCreateAt(String tokenCreateAt) {
		this.tokenCreateAt = tokenCreateAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getAccountCraeteAt() {
		return accountCraeteAt;
	}

	public void setAccountCraeteAt(String accountCraeteAt) {
		this.accountCraeteAt = accountCraeteAt;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getExplan() {
		return explan;
	}

	public void setExplan(String explan) {
		this.explan = explan;
	}


	
	
}
