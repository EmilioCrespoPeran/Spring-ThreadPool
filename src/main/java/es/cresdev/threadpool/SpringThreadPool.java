package es.cresdev.threadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringThreadPool {

	public static void main(String[] args) {
		SpringApplication.run(SpringThreadPool.class, args);
	}

}
