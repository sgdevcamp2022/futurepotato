package sg.fp.follow.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-server", url="http://localhost:8000/user")
public interface UserClient {

    @GetMapping("/{name}")
    String printName(@PathVariable("name")String name);

}
