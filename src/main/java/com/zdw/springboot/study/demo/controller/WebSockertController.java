package com.zdw.springboot.study.demo.controller;

import com.zdw.springboot.study.demo.entity.WiselyMessage;
import com.zdw.springboot.study.demo.entity.WiselyResponseMessage;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
public class WebSockertController {

    @RequestMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponseMessage sayHello(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponseMessage("欢迎使用websocket: "+message.getName());
    }

   @RequestMapping("/index")
    public String index(){
        return "index";
   }

}
