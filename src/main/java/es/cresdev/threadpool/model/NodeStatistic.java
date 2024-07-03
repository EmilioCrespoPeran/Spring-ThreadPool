package es.cresdev.threadpool.model;

import lombok.Data;

import java.util.Date;

@Data
public class NodeStatistic {

    Long received = 0L;
    Long processed = 0L;
    Long queue = 0L;
    Long success = 0L;
    Long error = 0L;
    Date since = new Date();

    public void received() { this.received++; }
    public void processed() { this.processed++; }
    public void queue() { this.queue++; }
    public void success() { this.success++; this.queue--; }
    public void error() { this.error++; this.queue--; }


}
