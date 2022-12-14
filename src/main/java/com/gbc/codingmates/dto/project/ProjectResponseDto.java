package com.gbc.codingmates.dto.project;

import com.gbc.codingmates.domain.project.Project;
import com.gbc.codingmates.dto.comment.CommentResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProjectResponseDto {
    private Long id;
    private String title;
    private String content;
    private String createdDate, modifiedDate;
    private Long member_id;
    private List<CommentResponseDto> comments;

    //entity to dto
    public ProjectResponseDto(Project project){
        this.id= project.getId();
        this.title= project.getTitle();
        this.content= project.getContent();
        this.createdDate = String.valueOf(project.getCreatedDate());
        this.modifiedDate = String.valueOf(project.getModifiedDate());
        this.member_id = project.getMember().getId();
//        this.comments = project.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
