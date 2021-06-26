package com.study.springboot.model.mybatis;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudyMember {

    private int memberSeq;
    private String memberName;
    private LocalDateTime joinDate;
    private String memberJob;
    private String createdAt;
    private String updatedAt;

    
}
