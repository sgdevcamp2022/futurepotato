package sg.fp.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="user-server", url="http://localhost:8000/user")
public interface FeignWithFeed {
    @PostMapping("/create")
    public void createUser(@RequestParam(value="accountId", required = true) String accountId,
                           @RequestParam(value="accountName", required = false) String accountName);
}