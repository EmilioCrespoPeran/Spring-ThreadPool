package es.cresdev.threadpool.controller.handler.node;

import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeRequestNameHandler extends NodeRequestHandler {

    Logger logger = LoggerFactory.getLogger(NodeRequestNameHandler.class);

    public NodeRequestNameHandler(NodeStatisticService nodeStatisticService) {
        super(nodeStatisticService);
    }

    @Override
    public void handle(Node request) {
        super.info("Comprobacion de nombre", request);
        if (request != null && !request.getName().equalsIgnoreCase("test")) {
            super.handle(request);
        }
        else {
            super.error("El evento es de prueba, no se procesa", request);
            super.nodeStatisticService.error(request);
        }
    }

}
