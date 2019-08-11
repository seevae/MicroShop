package com.qi.storeApp.po;

/**
 * Shopcar 数据传输类
 */
public class Shopcar implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int buynum;
	private int userId;
	private int articleId;
	
	private Article article;


	public void setBuynum(int buynum){
		this.buynum = buynum;
	}
	public int getBuynum(){
		return this.buynum;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}
	public int getArticleId(){
		return this.articleId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}