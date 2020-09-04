package com.example.demo.demo;

import com.example.demo.rabbitmq.springboot.producer.RouteTyeProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	RouteTyeProducer routeTyeProducer;

	@Test
	void contextLoads() {
		routeTyeProducer.sendMsg();
	}

}
