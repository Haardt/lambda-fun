package de.iritgo.lambda.di;

public interface UserProvider
        extends
        OrderServiceProvider,
        ArticleServiceProvider {

    void start();

    default User user() {
        return new User(orderService(), articleService());
    }
}
