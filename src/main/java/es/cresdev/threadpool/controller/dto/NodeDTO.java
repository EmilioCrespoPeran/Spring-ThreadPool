package es.cresdev.threadpool.controller.dto;

import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.model.NodeRequest;

import java.util.UUID;
import java.util.function.Function;

public class NodeDTO implements Function<NodeRequest, Node> {

    @Override
    public Node apply(NodeRequest nodeRequest) {
        return Node.builder()
                .id(UUID.randomUUID().toString())
                .timestamp(nodeRequest.getTimestamp())
                .name(nodeRequest.getName())
                .isFlag(nodeRequest.isFlag())
                .build();
    }
}
