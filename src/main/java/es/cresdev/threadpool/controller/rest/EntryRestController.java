package es.cresdev.threadpool.controller.rest;

import es.cresdev.threadpool.controller.NodeController;
import es.cresdev.threadpool.controller.dto.NodeDTO;
import es.cresdev.threadpool.controller.dto.NodeReportDTO;
import es.cresdev.threadpool.controller.factory.NodeRequestHandlerFactory;
import es.cresdev.threadpool.controller.handler.Handler;
import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.model.NodeRequest;
import es.cresdev.threadpool.model.NodeStatisticResponse;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RestController
public class EntryRestController {

    Logger logger = LoggerFactory.getLogger(EntryRestController.class);

    @Autowired
    private NodeRequestHandlerFactory factory;

    @Autowired
    private Executor threadPool;

    @Autowired
    private NodeStatisticService nodeStatisticService;

    private NodeDTO dto = new NodeDTO();
    private NodeReportDTO reportDTO = new NodeReportDTO();

    @PostMapping(value = "node")
    public void process(@RequestBody NodeRequest request) {
        Node node = dto.apply(request);
        nodeStatisticService.received(node);
        info("Recibido evento", node);

        Handler<Node> handler = factory.createNodeRequestHandler();
        threadPool.execute(new NodeController(nodeStatisticService, node));
    }

    @GetMapping(value = "report")
    public NodeStatisticResponse report() {
        return reportDTO.apply(nodeStatisticService.getReport());
    }

    private void info(String message, Node node) {
        logger.info(String.format("[%s] %s", node.getId(), message));
    }

}
