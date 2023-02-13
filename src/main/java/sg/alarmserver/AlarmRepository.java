package sg.alarmserver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<AlarmEntity,Long> {
    List<AlarmEntity> findAllByReceiver(String receiver);
}
