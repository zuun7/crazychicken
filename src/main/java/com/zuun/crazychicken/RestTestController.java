package com.zuun.crazychicken;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import com.zuun.crazychicken.domain.Greeting;
import com.zuun.crazychicken.domain.HelloMessage;

@Controller
public class RestTestController {
	@RequestMapping(value="/greeting") 
	public Greeting greeting() {
		return new Greeting("asdf");
	}
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
	    Thread.sleep(500); // simulated delay
	    return new Greeting(message.getName());
	}
}
