package de.iritgo.lambda.di;

/**
 * Created by held on 20.08.15.
 */
public class User
{
    private final OrderService orderService;
    private final ArticleService articleService;

    public User(OrderService orderService, ArticleService articleService) {
        this.orderService = orderService;
        this.articleService = articleService;
    }

    public void showPrice ()
    {
        System.out.println("OrderService: " + orderService.toString() + "ArticleService: " + articleService.toString());
    }
}
