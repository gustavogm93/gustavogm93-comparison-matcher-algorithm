package com.algorithm.comparison.matcher;

public interface ReadStrategy<T> {
    T parse(String[] fields);
}
