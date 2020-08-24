package me.xuyupeng.sbp.component;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * 自动运行的小工具
 *
 * @author xuyupeng
 * @date 2020/8/24
 */
@Slf4j
@Component
public class AutoRun implements CommandLineRunner {
    @Autowired
    private RedissonClient redissonClient;
    @Qualifier("autoRunExecutor")
    @Autowired
    private Executor executor;
    private final String SET_KEY = "mobile";
    private final long TIMEOUT_SECONDS = 10L;

    @Override
    public void run(String... args) throws Exception {
        int c = 10;
        while (c >= 0) {
            long sleepTime = (long) (Math.random() * 5000);
            log.info("{} : sleepTime = {}", Thread.currentThread().getName(), sleepTime);
            Thread.sleep(sleepTime);
            c--;
            executor.execute(() -> {
                String s = "13429870210+" + System.currentTimeMillis();
                RSetCache<Object> setCache = redissonClient.getSetCache(SET_KEY);
                setCache.stream("*13429870210*").forEach(System.out::println);
                long size = setCache.stream("*13429870210*").count();
                if (size < 3) {
                    setCache.add(s, TIMEOUT_SECONDS, TimeUnit.SECONDS);
                    log.info("success key = {} | count = {}", s, size);
                } else {
                    log.info("fail： key = {} | count = {}", s, size);
                }
            });
        }
    }
}
