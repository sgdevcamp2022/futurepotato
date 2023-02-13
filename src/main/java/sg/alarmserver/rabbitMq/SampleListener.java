package sg.alarmserver.rabbitMq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.alarmserver.AlarmEntity;
import sg.alarmserver.AlarmRepository;

import java.util.List;


@Service
public class SampleListener {
    @Autowired
    AlarmRepository alarmRepository;
    private static final Logger log = LoggerFactory.getLogger(SampleListener.class);

    @RabbitListener(queues = "alarmQ")
    public void listen(String message) {
        JSONObject jsonObj = new JSONObject(message);
        String sender = jsonObj.getString("sender");
        String receiver = jsonObj.getString("receiver");
        String place = jsonObj.getString("place");
        String action = jsonObj.getString("action");
        String aciontMsg = sender+"님이 "+place+"에 "+action;
        AlarmEntity alarmEntity = new AlarmEntity(sender, receiver, place, action, aciontMsg);
        alarmRepository.save(alarmEntity);
    }

    public List<AlarmEntity> getMessege(String accoutId) {
        List<AlarmEntity> allByReceiver = alarmRepository.findAllByReceiver(accoutId);
        return allByReceiver;
    }

}