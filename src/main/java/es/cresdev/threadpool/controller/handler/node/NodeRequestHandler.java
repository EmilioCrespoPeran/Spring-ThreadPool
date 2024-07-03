package es.cresdev.threadpool.controller.handler.node;

import es.cresdev.threadpool.controller.handler.Handler;
import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeRequestHandler implements Handler<Node> {

    Logger logger = LoggerFactory.getLogger(NodeRequestHandler.class);

    private Handler handler;

    protected NodeStatisticService nodeStatisticService;

    public NodeRequestHandler(NodeStatisticService nodeStatisticService) {
        this.nodeStatisticService = nodeStatisticService;
    }


    @Override
    public void setNext(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Node request) {
        if (handler != null) {
            handler.handle(request);
        }
    }

    protected void info(String message, Node node) {
        //logger.info(String.format("[%s][%s] %s", node.getId(), node.getName(), message));
    }

    protected void error(String message, Node node) {
        //logger.error(String.format("[%s][%s] %s: %s", node.getId(), node.getName(), message));
    }

}
