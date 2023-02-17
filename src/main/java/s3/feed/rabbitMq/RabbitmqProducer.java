/*
package s3.feed.rabbitMq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class RabbitmqProducer {
    private static final String EXCHANGE_NAME = "sample.exchange";
    private static final String QUEUE_NAME = "alarmQ";
    private static final String ROUTING_KEY = "sample.oingdaddy.#";

    @Autowired
    RabbitMessagingTemplate template;

    @Autowired
    RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(CustomMessage customMessage) throws JsonProcessingException {
            String json = objectMapper.writeValueAsString(customMessage);
        template.convertAndSend("alarmQ", json);
    }
    public void sendMessage2() throws JsonProcessingException {

        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY, "sender,receiver,post,comment");
    }

}
*/
