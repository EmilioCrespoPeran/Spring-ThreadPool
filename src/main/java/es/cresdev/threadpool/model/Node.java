package es.cresdev.threadpool.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Node {

    String id;
    long timestamp;
    String name;
    boolean isFlag;

}
