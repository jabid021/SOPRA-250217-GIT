package quest.rest;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/api/demo-reactif")
public class DemoReactifRestController {
    private Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> demoStreamLong() {
        return Flux.interval(Duration.ofSeconds(1));
    }
    
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> demoChat() {
        return this.sink.asFlux();
    }

    @GetMapping("/chat/send")
    public void send(@RequestParam String message) {
        this.sink.tryEmitNext(message);
    }
}
