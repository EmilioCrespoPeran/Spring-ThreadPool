package es.cresdev.threadpool.controller.factory;

import es.cresdev.threadpool.controller.handler.node.NodeRequestControllerHandler;
import es.cresdev.threadpool.controller.handler.node.NodeRequestFlagHandler;
import es.cresdev.threadpool.controller.handler.node.NodeRequestHandler;
import es.cresdev.threadpool.controller.handler.node.NodeRequestNameHandler;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.Executor;

@Controller
public class NodeRequestHandlerFactory {

    @Autowired
    private Executor threadPool;
    @Autowired
    private NodeStatisticService nodeStatisticService;

    public NodeRequestHandler createNodeRequestHandler() {
        NodeRequestHandler h1 = new NodeRequestHandler(nodeStatisticService);
        NodeRequestFlagHandler h2 = new NodeRequestFlagHandler(nodeStatisticService);
        NodeRequestNameHandler h3 = new NodeRequestNameHandler(nodeStatisticService);
        NodeRequestControllerHandler h4 = new NodeRequestControllerHandler(nodeStatisticService);

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);

        return h1;
    }
}
