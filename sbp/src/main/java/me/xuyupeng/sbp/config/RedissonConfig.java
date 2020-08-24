package me.xuyupeng.sbp.config;

import lombok.Getter;
import lombok.Setter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author xuyupeng
 * @date 2020/8/21
 */
@Getter
@Setter
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String passwd;

    @Value("${spring.redis.database}")
    private Integer database;
    @Bean
    public Config config() {
        String address  = "redis://" + host + ":" + port;
        Config config = new Config();
        if (StringUtils.isEmpty(passwd)){
        config.useSingleServer().setAddress(address).setDatabase(database);
        }else {
            config.useSingleServer().setAddress(address).setPassword(passwd).setDatabase(database);
        }
        config.setCodec(new JsonJacksonCodec());
        return config;
    }

    @Bean
    public RedissonClient redissonClient(Config config) {
        return Redisson.create(config);
    }
}
