package com.yinghao.domain.wechat.resp;

import java.util.List;

/**
 * 图文消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class NewsMessage extends PlatformBaseMessage {

    private int ArticleCount;// 图文消息个数，限制为10条以内

    private List<Article> Articles;// 多条图文消息信息，默认第一个item为大图

    public int getArticleCount() { return ArticleCount; }
    public void setArticleCount(int articleCount) { ArticleCount = articleCount; }

    public List<Article> getArticles() { return Articles; }
    public void setArticles(List<Article> articles) { Articles = articles; }
}
