package com.server;

import javax.xml.ws.Endpoint;
import com.service.*;


public class Server {
 
    public static void main(String[] args) {
 
        Endpoint.publish("http://localhost:9898/HelloWeb", new HelloWeb());
 
        System.out.println("HelloWeb service is ready");
 
    }
 
}
