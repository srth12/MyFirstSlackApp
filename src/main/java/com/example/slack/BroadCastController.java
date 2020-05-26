package com.example.slack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BroadCastController {

    @Autowired
    private BroadcastService broadcastService;

    /**
     * Endpoint to broadcast the message to slack boat app subscribers
     * @param message plain text message that needs to be broadcast
     * @return status of the broadcast
     */
    @PostMapping("/broadcast")
    public ResponseEntity<String> broadcastMessage(@RequestBody String message){
        return broadcastService.broadcastMessage(message);
    }
}
