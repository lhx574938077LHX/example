package com.icefox.Thread2;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import org.apache.http.annotation.GuardedBy;

/*
 *  用SocketUsingTask 代替 Callable，为Callable 增加了 cancel 方法，来关闭socket，
 *  不仅中断了线程，还关闭了socket
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {

    @GuardedBy("this")
    private Socket socket;

    protected synchronized void setSocket(Socket s) {
        socket = s;
    }

    public synchronized void cancel() {
        try {
            if (socket != null)
                socket.close();
        } catch (IOException ignored) {
        }
    }

    @SuppressWarnings("finally")
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {

            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancel();
                } finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }

}
