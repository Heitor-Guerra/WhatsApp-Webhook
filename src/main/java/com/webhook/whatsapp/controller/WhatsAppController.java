package com.webhook.whatsapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
class WhatsAppController {
  final private String verifyToken = "MyTestToken";

  // GET request for webhook verification
  @GetMapping
  public ResponseEntity<String> verifyWebhook(
      @RequestParam("hub.mode") String mode,
      @RequestParam("hub.verify_token") String token,
      @RequestParam("hub.challenge") String challenge) {

    if (mode.equals("subscribe") && token.equals(verifyToken)) {
      return ResponseEntity.ok(challenge);
    } else {
      return ResponseEntity.status(403).body("Verification failed");
    }
  }

  // POST request to receive incoming messages
  @PostMapping()
  public ResponseEntity<Void> handleIncomingMessage(@RequestBody String payload) {
    System.out.println("Received: " + payload);
    return ResponseEntity.ok().build();
  }
}
