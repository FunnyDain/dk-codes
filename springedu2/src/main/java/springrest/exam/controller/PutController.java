package springrest.exam.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/default")
    public String putMethod() {
        return "안녕? PUT 방식 요청 했네~~~";
    }

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDto) {
        return memberDto.toString();
    }


    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDto) {
        return memberDto;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDto) {
//        ResponseEntity객체를 만드는 방법은 post처럼 생성자를 이용하거나
//        put예제처럼 static메서드를 통해 생성하는 것도 가능
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)        //ACCEPTED = 202 = 변경했다.
            .body(memberDto);
        //응답 body의 기본은 json
    }
}