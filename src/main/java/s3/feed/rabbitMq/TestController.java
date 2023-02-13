package s3.feed.rabbitMq;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitmqProducer rabbitmqProducer;
    @Autowired
    RabbitMessagingTemplate template;


    @GetMapping("/test2")
    public String test2() throws JsonProcessingException {
        CustomMessage customMessage = new CustomMessage("sender2", "receiver2", "post2","댓글");
        rabbitmqProducer.sendMessage(customMessage);
        return "costom OK";
    }

    @GetMapping("/test")
    public String test() throws JsonProcessingException {
        rabbitmqProducer.sendMessage2();
        return "like OK";
    }
}
