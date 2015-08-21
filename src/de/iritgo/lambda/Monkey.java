package de.iritgo.lambda;

import java.util.function.Supplier;

public class Monkey<T>
{
    private Supplier<T> supplier;

    public Monkey(Supplier<T> defaultSupplier)
    {
        this.supplier = defaultSupplier;
    }

    public T action ()
    {
        return supplier.get();
    }

    public void action(Supplier<T> supplier)
    {
        this.supplier = supplier;
    }
}
