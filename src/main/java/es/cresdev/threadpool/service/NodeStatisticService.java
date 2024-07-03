package es.cresdev.threadpool.service;

import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.model.NodeStatistic;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NodeStatisticService {

    private final NodeStatistic nodeStatistics = new NodeStatistic();

    @Async
    public void received(Node node) {
        nodeStatistics.received();
    }

    @Async
    public void queue(Node node) {
        nodeStatistics.queue();
    }

    @Async
    public void success(Node node) {
        nodeStatistics.processed();
        nodeStatistics.success();
    }

    @Async
    public void error(Node node) {
        nodeStatistics.processed();
        nodeStatistics.error();
        nodeStatistics.queue();
    }

    public NodeStatistic getReport() {
        return this.nodeStatistics;
    }

}
