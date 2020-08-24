package me.xuyupeng.sbp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * executor配置
 *
 * @author xuyupeng
 * @date 2020/8/24
 */
@Configuration
public class ExecutorConfig {
    /**
     * autoRunExecutor
     *
     * @return executor
     */
    @Bean("autoRunExecutor")
    public Executor autoRunExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("autoRun-thread-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setQueueCapacity(20);
        return executor;
    }
}
