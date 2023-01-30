package sg.fp.follow.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sg.fp.follow.service.BlockService;
import sg.fp.follow.service.FollowService;

@Slf4j
@RestController
public class BlockController {
    @Autowired
    private BlockService blockService;

    //5. 차단

    //6. 차단해제

}
