package de.iritgo.lambda.di;

/**
 * Created by held on 20.08.15.
 */
public interface OrderServiceProvider {

    default OrderService orderService()
    {
        return new OrderService();
    }
}
