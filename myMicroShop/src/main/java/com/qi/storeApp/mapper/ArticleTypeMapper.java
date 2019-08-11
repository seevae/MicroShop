package com.qi.storeApp.mapper;

import java.util.List;

import com.qi.storeApp.po.ArticleType;
import org.apache.ibatis.annotations.Select;

/**
 * ArticleTypeMapper 数据访问类
 */
public interface ArticleTypeMapper {

    //    获取所有一级商品的类型
    @Select("select * from ec_article_type where length(code) =4")
    List<ArticleType> findAllFirstArticleType();

    //根据一级物品查询二级物品
    @Select("select * from ec_article_type where code like #{typeCode} and length(code) = 8")
    List<ArticleType> findAllSecondArticleTypes(String typeCode);
}