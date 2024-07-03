package es.cresdev.threadpool.controller.handler.node;

import es.cresdev.threadpool.controller.NodeController;
import es.cresdev.threadpool.controller.dto.NodeDTO;
import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;


public class NodeRequestControllerHandler extends NodeRequestHandler {

    Logger logger = LoggerFactory.getLogger(NodeRequestControllerHandler.class);

    private Executor taskExecutor;
    private NodeDTO dto;

    public NodeRequestControllerHandler(NodeStatisticService nodeStatisticService) {
        super(nodeStatisticService);
        this.dto = new NodeDTO();
    }

    @Override
    public void handle(Node request) {
        super.info("Ejecuta controlador", request);
        super.nodeStatisticService.queue(request);
        new NodeController(super.nodeStatisticService, request);
    }

}
