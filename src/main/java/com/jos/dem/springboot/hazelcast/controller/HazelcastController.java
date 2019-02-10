package com.jos.dem.springboot.hazelcast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/hazelcast")
public class HazelcastController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @PostMapping("/write/{key}/{value}")
  public String write(@PathVariable("key") String key, @PathVariable("value") String value) {
    log.info("Storing key: {} with value: {}", key, value);
    return "Key and value stored";
  }

}
