package sg.graphServer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sg.graphServer.dto.ResponseDTO;
import sg.graphServer.entity.Account;
import sg.graphServer.service.GraphService;

import java.util.List;

@Slf4j
@RestController
public class GraphController {
    @Autowired
    private GraphService graphService;

    @GetMapping("")
    public String graphServer() { return "graph server ok";  }
    //1. 소셜 관계 신청 : 팔로우, 차단
    @PostMapping("{senderId}/{request}/{recipientId}")
    public ResponseEntity<?> socialRequest(@PathVariable String senderId, @PathVariable String request, @PathVariable String recipientId) {
        try {
            graphService.socialRequest(request, senderId, recipientId);
            log.info("{} is {}ing {}", senderId ,request, recipientId);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            ResponseDTO response = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //2. 소셜 관계 신청 취소 : 팔로우 취소, 차단 취소
    @DeleteMapping("{senderId}/{request}/{recipientId}")
    public ResponseEntity<?> cancelSocialRequest(@PathVariable String senderId, @PathVariable String request, @PathVariable String recipientId) {
        try {
            graphService.cancelSocialRequest(request, senderId, recipientId);
            log.info("{} is un{}s {}", senderId, request, recipientId);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            ResponseDTO response = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //3. accountId가 소셜 관계 신청한/신청받은 계정 목록 조회 : 팔로잉 목록, 블록킹 목록 / 팔로우 목록, 블록커 목록
    @GetMapping("/{accountId}/{request}")
    public ResponseEntity<?> findFollowing(@PathVariable String accountId, @PathVariable String request){
        try{
            List<Account> RequestingList = graphService.findRequest(request, accountId);
            ResponseDTO response = ResponseDTO.<Account>builder().data(RequestingList).build();
            return ResponseEntity.ok().body( response);
        } catch (Exception e){
            ResponseDTO response = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //4. 해당 relation 을 맺고 있는지 확인 : isFollowing, isBlocking
    @GetMapping("/{senderId}/is{request}ing/{recipientId}")
    public ResponseEntity<?> isRequesting(@PathVariable String senderId, @PathVariable String request, @PathVariable String recipientId){
        try {
            boolean result = graphService.isRequesting(request, senderId, recipientId);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            ResponseDTO response = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
