package com.qi.storeApp.mapper;

import java.util.List;

import com.qi.storeApp.po.Article;
import com.qi.storeApp.po.ArticleType;
import com.qi.storeApp.until.PageModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * ArticleMapper 数据访问类
 */
public interface ArticleMapper {

    //根据商品类型获取商品信息
    List<Article> findAllArticle(@Param("typeCode") String typeCode, @Param("keyword") String keyword, @Param("pageModel") PageModel pageModel);

    //根据商品id获取商品详细信息
    @Select("select * from ec_article where id = #{id}")
    Article getArticleById(Integer id);

    //查询总记录数
    int findTotalNum(@Param("typeCode") String typeCode, @Param("keyword")String keyword);
}