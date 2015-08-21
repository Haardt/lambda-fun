package de.iritgo.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Mappable<T> extends DelegatesTo<List<T>> {
    default <R> List<R> map(Function<T, R> mapper) {
        return delegate().stream().map(mapper).collect(Collectors.toList());
    }
}
