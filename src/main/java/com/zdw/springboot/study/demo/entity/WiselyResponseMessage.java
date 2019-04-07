package com.zdw.springboot.study.demo.entity;

import lombok.Data;

@Data
public class WiselyResponseMessage {
    private String responseMessage;

    public WiselyResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
