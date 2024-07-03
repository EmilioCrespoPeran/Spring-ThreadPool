package es.cresdev.threadpool.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Source: https://www.tamimsyed.xyz/blog/how-to-configure-threads-for-spring-boot-application
 */

@Configuration
@EnableAsync
public class ThreadPoolConfiguration implements AsyncConfigurer {

    @Value("${thread.core-pool-size}")
    private int poolSize;

    @Value("${thread.max-pool-size}")
    private int maxPoolSize;

    @Value("${thread.queue-size}")
    private int queueSize;


    @Bean
    public ThreadPoolTaskExecutor threadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueSize);
        executor.setThreadNamePrefix("ThreadPool-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}