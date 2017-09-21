package com.icefox.Thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancle();

    RunnableFuture<T> newTask();
}
