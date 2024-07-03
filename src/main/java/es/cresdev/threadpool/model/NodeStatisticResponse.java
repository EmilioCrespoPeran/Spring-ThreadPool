package es.cresdev.threadpool.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data @Builder
public class NodeStatisticResponse {

    private Date report_init;
    private Long processed;
    private Long received;
    private Long queue;
    private Long success;
    private Long error;
    private double processed_perc;

    public double getProcessed_perc() {
        return (received != 0) ? processed / received * 100 : 0;
    }
}
