package es.cresdev.threadpool.controller.handler;

public interface Handler<T> {

    void setNext (Handler handler);

    void handle(T request);

}
