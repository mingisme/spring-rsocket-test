package com.swang.rsocketserver;

import com.swang.rsocketserver.data.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@Controller
public class RSocketController {

    static final String SERVER = "Server";
    static final String RESPONSE = "Response";
    static final String STREAM = "Stream";

    @MessageMapping("request-response")
    Message requestResponse(Message request) {
        log.info("Received request-response request: {}", request);
        // create a single Message and return it
        return new Message(SERVER, RESPONSE);
    }

    @MessageMapping("fire-and-forget")
    public void fireAndForget(Message request) {
        log.info("Received fire-and-forget request: {}", request);
    }

    @MessageMapping("stream")
    Flux<Message> stream(Message request) {
        log.info("Received stream request: {}", request);
        return Flux
                .interval(Duration.ofSeconds(1))
                .map(index -> new Message(SERVER, STREAM, index))
                .log();
    }
}
