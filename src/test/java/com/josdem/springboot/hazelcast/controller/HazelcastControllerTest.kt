package com.josdem.springboot.hazelcast.controller

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class HazelcastControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    @Order(1)
    fun `should store a value in the map`(testInfo: TestInfo) {
        log.info(testInfo.displayName)
        val request =
            post("/hazelcast/write/1/value1")
        mockMvc
            .perform(request)
            .andExpect(status().isOk())
    }

    @Test
    @Order(2)
    fun `should get a value from the map`(testInfo: TestInfo) {
        log.info(testInfo.displayName)
        val request =
            get("/hazelcast/read/1")
        mockMvc
            .perform(request)
            .andExpect(status().isOk())
    }


}