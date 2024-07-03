package es.cresdev.threadpool.controller.handler.node;

import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeRequestFlagHandler extends NodeRequestHandler {

    Logger logger = LoggerFactory.getLogger(NodeRequestFlagHandler.class);

    public NodeRequestFlagHandler(NodeStatisticService nodeStatisticService) {
        super(nodeStatisticService);
    }

    @Override
    public void handle(Node request) {
        super.info("Comprobacion de flag", request);
        if (request != null && request.isFlag()) {
            super.handle(request);
        }
        else {
            super.error("El evento no tiene el flag activado", request);
            super.nodeStatisticService.error(request);
        }
    }

}
