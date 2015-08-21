package de.iritgo.lambda.di;

/**
 * Created by held on 20.08.15.
 */
public interface ArticleServiceProvider {

    default ArticleService articleService()
    {
        return new ArticleService();
    }

}
