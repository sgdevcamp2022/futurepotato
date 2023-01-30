package sg.fp.follow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.fp.follow.feign.AuthClient;
import sg.fp.follow.feign.UserClient;
import sg.fp.follow.repository.AccountRepository;

@Slf4j
@Service
public class BlockService {
    @Autowired
    private UserClient userClient;
    @Autowired
    private AuthClient authClient;
    @Autowired
    private AccountRepository accountRepository;

}
