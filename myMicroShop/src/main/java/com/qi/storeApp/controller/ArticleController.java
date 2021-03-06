package com.qi.storeApp.controller;

import com.qi.storeApp.po.Article;
import com.qi.storeApp.po.ArticleType;
import com.qi.storeApp.service.ArticleServiceI;
import com.qi.storeApp.until.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceI articleService;

    @RequestMapping("/index")
    public String articleIndex(Model model, String typeCode, String keyword, PageModel pageModel){

        //获取所有的一级物品类型(物品类型)
        List<ArticleType> articleTypes = articleService.findAllFirstArticleType();
        model.addAttribute("articleTypes",articleTypes);

        //如果typecode不为空,则根据typeCode查询二级物品类型
        if(typeCode!=null && !typeCode.equals("")){

            String code = typeCode.substring(0,4);
            //根据一级物品类型获取对应的二级物品类型信息
            List<ArticleType> seArticleTypes = articleService.findAllSecondArticleTypes(code+"%");

            model.addAttribute("secondArticleTypes",seArticleTypes);
        }

        //根据用户指定的商品类型查询数据库,获取相应的商品信息
        List<Article> articles = articleService.findAllArticle(typeCode == null?null:typeCode+"%",keyword==null ? null: "%"+keyword+"%",pageModel);
        model.addAttribute("articles",articles);

        //查询总记录数
        int totleNum = articleService.findTotalNum(typeCode == null?null:typeCode+"%",keyword==null ? null: "%"+keyword+"%");
        pageModel.setTotalNum(totleNum);

        return "articleIndex";
    }

    //根据商品id获取商品详情信息
    @RequestMapping("/detail")
    public String articleDetail(Integer id,Model model){
        //根据商品id获取商品信息
        Article article = articleService.getArticleById(id);
        model.addAttribute("article",article);

        return "articleDetail";
    }

}




















