package com.study.springboot.controller;

import com.study.springboot.model.exception.ErrorInfo;
import com.study.springboot.model.exception.ErrorResponse;
import com.study.springboot.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyMemberController {

    @Autowired
    private StudyMemberService studyMemberService;

    //  =======================================================================
    // 단건 조회
//    @GetMapping("/members/{member_id}")
//    public List<String> members(@PathVariable("member_id") String memberId) {
//        return studyMemberService.getMemberListWithNameAndSeq();
//    }

    // 전체 조회
//    @GetMapping("/members")
//    public List<String> members(@PathVariable("member_id") String memberId) {
//        return studyMemberService.getMemberListWithNameAndSeq();
//    }
    //  =======================================================================

    // xml 방식으로 리턴하지만 MessageConverter 가 없어서 애러난다.
//    @GetMapping(value = "/members/1", produces = "application/xml")

//    @GetMapping("/members/1")
//    public List<String> members() {
//        return studyMemberService.getMemberListWithNameAndSeq();
//    }

//    @PostMapping("/members/1")
//    public ResponseEntity<List<String>> membersWithEntity() {
//        return ResponseEntity.ok(studyMemberService.getMemberListWithNameAndSeq());
//    }


    @GetMapping("/members/{member_id}")
    public List<String> members(@PathVariable("member_id") int memberSeq) {
        System.out.println("memberSeq = " + memberSeq);
        return studyMemberService.getMemberListWithNameAndSeq();
    }


//    @ControllerAdvice // 전역에서 동작
    @ExceptionHandler // 자기가 있는 class에서 동작
    public ErrorResponse handleNumberFormatException(NumberFormatException e) {

        // make return vo // model.exception.ErrorResponse
        // Timestamp
        // error info
        // error redirect link

        return ErrorResponse.of()
                .timestamp(LocalDateTime.now())
                .errorInfo(ErrorInfo.INVALID_PARAMETER.getInfo())
                .build();
    }
}
