/*
package s3.feed.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@EnableAsync
public class ScheduleService {

    @Scheduled(fixedRate = 3000)
    @Async
    public void schedule() throws InterruptedException {


        System.out.println(new Date().toString());
        System.out.println("10초간 스케줄러");

    }
    @Scheduled(cron = "5 * * * * *")
    public void printDate () {
        System.out.println(new Date().toString());
    }
}
*/
