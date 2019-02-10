package com.jos.dem.springboot.hazelcast.controller;

import java.util.Map;

import com.hazelcast.core.HazelcastInstance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/hazelcast")
public class HazelcastController {

  @Autowired
  private HazelcastInstance hazelcastInstance;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @PostMapping("/write/{key}/{value}")
  public String write(@PathVariable("key") String key, @PathVariable("value") String value) {
    log.info("Storing key: {} with value: {}", key, value);
    Map<String, String> map = hazelcastInstance.getMap("memory");
    map.put(key, value);
    return "Key and value stored";
  }

  @GetMapping("/read/{key}")
  public String read(@PathVariable("key") String key){
    log.info("Reading stored value with key: {}", key);
    Map<String, String> map = hazelcastInstance.getMap("memory");
    return map.get(key);
  }

}
