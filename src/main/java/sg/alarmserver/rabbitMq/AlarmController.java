package sg.alarmserver.rabbitMq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sg.alarmserver.AlarmEntity;

import java.util.List;

@RestController
public class AlarmController {
    @Autowired
    SampleListener sampleListener;

    private static final Logger log = LoggerFactory.getLogger(AlarmController.class);

    @GetMapping("/{accountId}")
    public List<AlarmEntity> getAction(@PathVariable("accountId")String accountId) {
        List<AlarmEntity> messege = sampleListener.getMessege(accountId);
        return messege;
    }

}
