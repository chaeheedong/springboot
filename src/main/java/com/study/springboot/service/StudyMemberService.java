package com.study.springboot.service;

import com.study.springboot.model.mybatis.StudyMember;
import com.study.springboot.repository.mybatis.StudyMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyMemberService {

    private final StudyMemberMapper studyMemberMapper;

    public List<String> getMemberListWithNameAndSeq() {
        List<StudyMember> memberList = studyMemberMapper.selectAll();

        return memberList.stream()
                .map( member -> {
                    int seq = member.getMemberSeq();
                    String name = member.getMemberName();
                    return name + seq;
                })
                .collect(Collectors.toList());
    }
}
