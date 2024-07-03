package es.cresdev.threadpool.controller.dto;

import es.cresdev.threadpool.model.NodeStatistic;
import es.cresdev.threadpool.model.NodeStatisticResponse;

import java.util.function.Function;

public class NodeReportDTO implements Function<NodeStatistic, NodeStatisticResponse> {

    @Override
    public NodeStatisticResponse apply(NodeStatistic nodeStatistic) {
        return NodeStatisticResponse.builder()
                .received(nodeStatistic.getReceived())
                .processed(nodeStatistic.getProcessed())
                .error(nodeStatistic.getError())
                .success(nodeStatistic.getSuccess())
                .queue(nodeStatistic.getQueue())
                .report_init(nodeStatistic.getSince())
                .build();
    }

}
