package com.qi.storeApp.service.Impl;/*
    name zhang;
    */

import com.qi.storeApp.mapper.ArticleMapper;
import com.qi.storeApp.mapper.ArticleTypeMapper;
import com.qi.storeApp.po.Article;
import com.qi.storeApp.po.ArticleType;
import com.qi.storeApp.service.ArticleServiceI;
import com.qi.storeApp.until.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleServiceI {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    //查询所有的一次物品类型
    public List<ArticleType> findAllFirstArticleType() {
        List<ArticleType> articleTypes = articleTypeMapper.findAllFirstArticleType();
        return articleTypes;
    }

    //根据商品类型获取商品信息
    public List<Article> findAllArticle(String typeCode, String keyword, PageModel pageModel) {
        List<Article> articles = articleMapper.findAllArticle(typeCode,keyword,pageModel);

        return articles;
    }

    //根据一级物品类型获取对应的二级物品类型
    public List<ArticleType> findAllSecondArticleTypes(String typeCode) {
        List<ArticleType> articleTypes =  articleTypeMapper.findAllSecondArticleTypes(typeCode);
        return articleTypes;
    }

    //根据商品id获取商品详细信息
    public Article getArticleById(Integer id) {
        Article article = articleMapper.getArticleById(id);
        return article;
    }

    //查询商品总记录数
    public int findTotalNum(String typeCode, String keyword) {

        return articleMapper.findTotalNum(typeCode,keyword);
    }
}
