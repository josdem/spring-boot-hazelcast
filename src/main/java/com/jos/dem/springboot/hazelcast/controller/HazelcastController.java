package com.jos.dem.springboot.hazelcast.controller;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hazelcast")
@RequiredArgsConstructor
public class HazelcastController {

    private final HazelcastInstance hazelcastInstance;

    @PostMapping("/write/{key}/{value}")
    public String write(@PathVariable("key") String key, @PathVariable("value") String value) {
        log.info("Storing key: {} with value: {}", key, value);
        Map<String, String> map = hazelcastInstance.getMap("memory");
        map.putIfAbsent(key, value);
        return "Key and value stored";
    }

    @GetMapping("/read/{key}")
    public String read(@PathVariable("key") String key) {
        log.info("Reading stored value with key: {}", key);
        Map<String, String> map = hazelcastInstance.getMap("memory");
        return map.get(key);
    }

}
