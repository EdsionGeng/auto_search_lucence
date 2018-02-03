package com.wsd.search.controller;

import com.wsd.search.dao.ArticleSearchRepository;
import com.wsd.search.entity.Article;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * Created by EdsionGeng on 2018/2/3.
 */
@RestController
public class SearchController {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @RequestMapping("/add")
    public String testSaveArticleIndex() {
//        Author author = new Author();
//        author.setId(1L);
//        author.setName("tianshouzhi");
//        author.setRemark("java developer");
//
//        Tutorial tutorial = new Tutorial();
//        tutorial.setId(1L);
//        tutorial.setName("elastic search");
        Article article = new Article();
        article.setId(2L);
        article.setTitle("你们平台安全吗");
        article.setContent("我们平台是国资背景，实力雄厚，想跑路带那么多钱也跑不动");
        article.setPostTime("2018-02-02 14:15:58");
        article.setClickCount(1L);
        articleSearchRepository.save(article);
        return "success";
    }

    @RequestMapping("/query")
    public String  testSearch() {
        String queryString = "国资";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        String str = "";
        while (iterator.hasNext()) {
            str = iterator.next().getContent();
        }
        return str;
    }
}
