package sg.alarmserver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor

@Getter
@Entity
public class AlarmEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public String sender;
    public String receiver;
    public String place;
    public String action;
    public String actionMessage;

    public AlarmEntity(String sender, String receiver, String place, String action, String actionMessage) {
        this.sender = sender;
        this.receiver = receiver;
        this.place = place;
        this.action = action;
        this.actionMessage = actionMessage;
    }
}
