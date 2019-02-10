package com.jos.dem.springboot.hazelcast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HazelcastController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/write/{key}/{value}")
  public String write(@PathVariable("key") String key, @PathVariable("value") Stirng value) {
    log.info("Storing key: {0} with valye: {1}", key, value);
    return "Key and value stored";
  }

}
