package sg.fp.follow.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sg.fp.follow.dto.AccountDTO;

@FeignClient(name="auth-server", url="http://localhost:8000/auth")
public interface AuthClient {



    @PostMapping("/signin")
    String getAccountId(@RequestBody AccountDTO accountDTO);


}
