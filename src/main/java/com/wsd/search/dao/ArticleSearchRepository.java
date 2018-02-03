package com.wsd.search.dao;

import com.wsd.search.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by EdsionGeng on 2018/2/3.
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article,Long> {
}
