package com.qi.storeApp.service;


import com.qi.storeApp.po.Article;
import com.qi.storeApp.po.ArticleType;
import com.qi.storeApp.until.PageModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleServiceI {

    //获取所有的一级物品类型
    List<ArticleType> findAllFirstArticleType();

    //根据商品类型获取商品信息
    List<Article> findAllArticle(String typeCode, String keyord, PageModel pageModel);

    //根据一级物品类型获取对应的二级物品类型信息
    List<ArticleType> findAllSecondArticleTypes(String string);

    //根据商品id获取商品详细信息
    Article getArticleById(Integer id);

    //查询商品总记录数
    int findTotalNum(String typeCode, String keyword);
}
