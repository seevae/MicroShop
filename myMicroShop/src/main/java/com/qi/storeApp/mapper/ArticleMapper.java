package com.qi.storeApp.mapper;

import java.util.List;

import com.qi.storeApp.po.Article;
import com.qi.storeApp.po.ArticleType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * ArticleMapper 数据访问类
 */
public interface ArticleMapper {

    //根据商品类型获取商品信息
    List<Article> findAllArticle(@Param("typeCode") String typeCode,@Param("keyword") String keyword);

    //根据商品id获取商品详细信息
    @Select("select * from ec_article where id = #{id}")
    Article getArticleById(Integer id);

}