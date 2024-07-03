package es.cresdev.threadpool.controller;

import es.cresdev.threadpool.model.Node;
import es.cresdev.threadpool.service.NodeStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeController extends Thread {

    Logger logger = LoggerFactory.getLogger(NodeController.class);

    private final NodeStatisticService nodeStatisticService;
    private final Node node;

    public NodeController (NodeStatisticService nodeStatisticService, Node node) {
        this.nodeStatisticService = nodeStatisticService;
        this.node = node;
    }

    @Override
    public void run() {
        try {
            info("Ejecutando el evento");

            search();

            info("El evento se ha procesado");
            nodeStatisticService.success(node);
        }
        catch (Exception e) {
            error("Error al procesar el evento", e);
            nodeStatisticService.error(node);
        }
    }


    public void search() throws InterruptedException {
        info("Buscando datos...");
        Thread.sleep(1000);
    }

    private void info(String message) {
        logger.info(String.format("[%s] %s", node.getId(), message));
    }

    private void error(String message, Exception exception) {
        logger.error(String.format("[%s] %s: %s", node.getId(), message, exception.getMessage()));
    }

}
