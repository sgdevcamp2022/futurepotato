package sg.alarmserver.rabbitMq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Dto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqActionDto {
        public String sender;
        public String receiver;
        public String place;
        public String action;
        public String actionMessage;
    }

}
