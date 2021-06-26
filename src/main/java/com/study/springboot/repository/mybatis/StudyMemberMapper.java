package com.study.springboot.repository.mybatis;

import com.study.springboot.model.mybatis.StudyMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Application에 @MapperScan 없으면 스프링컨테이너에 없어서 에러남
public interface StudyMemberMapper {

    public List<StudyMember> selectAll();
}
