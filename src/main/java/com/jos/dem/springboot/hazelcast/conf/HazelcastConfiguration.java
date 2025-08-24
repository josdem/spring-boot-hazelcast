package com.jos.dem.springboot.hazelcast.conf;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HazelcastConfiguration {

    private final static int MAX_SIZE = 200;

    @Bean
    public Config hazelCastConfig() {
        var evictionConfig = new EvictionConfig()
                .setEvictionPolicy(EvictionPolicy.LFU)
                .setMaxSizePolicy(MaxSizePolicy.USED_HEAP_PERCENTAGE)
                .setSize(MAX_SIZE);

        return new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("configuration")
                                .setEvictionConfig(evictionConfig)
                                .setTimeToLiveSeconds(-1));
    }

}
