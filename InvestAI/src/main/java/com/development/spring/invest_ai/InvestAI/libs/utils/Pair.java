package com.development.spring.invest_ai.InvestAI.libs.utils;

import lombok.Getter;

@Getter
public class Pair<S, T> {
    private final S first;
    private final T second;

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getSecond() {
        return second;
    }

    public S getFirst() {
        return first;
    }
}
