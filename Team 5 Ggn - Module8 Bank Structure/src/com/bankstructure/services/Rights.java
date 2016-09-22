package com.bankstructure.services;

import java.io.Serializable;

public class Rights implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
//	Declare All Variables	
	
	private int desk_id;
	private String mod;
	private int get;
	private int put;
	private int post;
	private int del;
	private int fin_lim;
	private String getParam;
	private String putParam;
	private String postParam;
	private String delParam;
	
//	Define Constructor
	
	public Rights(){}
	
	public Rights(int desk_id, String mod, int get, int put, int post, int del, int fin_lim, String getParam, String postParam, String putParam, String delParam) {
		this.setDesk_id(desk_id);
		this.setMod(mod);
		this.setGet(get);
		this.setPost(post);
		this.setPut(put);
		this.setDel(del);
		this.setFin_lim(fin_lim);
		this.setGetParam(getParam);
		this.setPostParam(postParam);
		this.setPutParam(putParam);
		this.setDelParam(delParam);
	}

	/**
	 * @return the desk_id
	 */
	public int getDesk_id() {
		return desk_id;
	}

	/**
	 * @param desk_id the desk_id to set
	 */
	public void setDesk_id(int desk_id) {
		this.desk_id = desk_id;
	}

	/**
	 * @return the mod
	 */
	public String getMod() {
		return mod;
	}

	/**
	 * @param mod the mod to set
	 */
	public void setMod(String mod) {
		this.mod = mod;
	}

	/**
	 * @return the get
	 */
	public int getGet() {
		return get;
	}

	/**
	 * @param get the get to set
	 */
	public void setGet(int get) {
		this.get = get;
	}

	/**
	 * @return the put
	 */
	public int getPut() {
		return put;
	}

	/**
	 * @param put the put to set
	 */
	public void setPut(int put) {
		this.put = put;
	}

	/**
	 * @return the post
	 */
	public int getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(int post) {
		this.post = post;
	}

	/**
	 * @return the del
	 */
	public int getDel() {
		return del;
	}

	/**
	 * @param del the del to set
	 */
	public void setDel(int del) {
		this.del = del;
	}
	
	/**
	 * @return the fin_lim
	 */
	public int getFin_lim() {
		return fin_lim;
	}

	/**
	 * @param fin_lim the fin_lim to set
	 */
	public void setFin_lim(int fin_lim) {
		this.fin_lim = fin_lim;
	}

	/**
	 * @return the getParam
	 */
	public String getGetParam() {
		return getParam;
	}

	/**
	 * @param getParam the getParam to set
	 */
	public void setGetParam(String getParam) {
		this.getParam = getParam;
	}

	/**
	 * @return the putParam
	 */
	public String getPutParam() {
		return putParam;
	}

	/**
	 * @param putParam the putParam to set
	 */
	public void setPutParam(String putParam) {
		this.putParam = putParam;
	}

	/**
	 * @return the postParam
	 */
	public String getPostParam() {
		return postParam;
	}

	/**
	 * @param postParam the postParam to set
	 */
	public void setPostParam(String postParam) {
		this.postParam = postParam;
	}

	/**
	 * @return the delParam
	 */
	public String getDelParam() {
		return delParam;
	}

	/**
	 * @param delParam the delParam to set
	 */
	public void setDelParam(String delParam) {
		this.delParam = delParam;
	}

	@Override
	public String toString() {
		return "Rights [desk_id=" + desk_id + ", mod=" + mod + ", get=" + get + ", put=" + put + ", post=" + post
				+ ", del=" + del + ", fin_lim=" + fin_lim + ", getParam=" + getParam + ", putParam=" + putParam
				+ ", postParam=" + postParam + ", delParam=" + delParam + "]";
	}
	
}