package com.study.springboot.controller;

import com.study.springboot.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/study")
public class StudyMemberController {

    @Autowired
    private StudyMemberService studyMemberService;

// @ControllerAdvice

    // xml 방식으로 리턴하지만 MessageConverter 가 없어서 애러난다.
//    @GetMapping(value = "/members/1", produces = "application/xml")
    @GetMapping("/members/1")
    public List<String> members() {
        return studyMemberService.getMemberListWithNameAndSeq();
    }

    @GetMapping("/members/2")
    public ResponseEntity<List<String>> membersWithEntity() {
        return ResponseEntity.ok(studyMemberService.getMemberListWithNameAndSeq());
    }
}
