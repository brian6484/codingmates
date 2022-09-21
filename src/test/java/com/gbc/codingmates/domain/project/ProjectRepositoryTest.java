package com.gbc.codingmates.domain.project;

import com.gbc.codingmates.domain.member.Member;
import com.gbc.codingmates.dto.project.ProjectDto;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    //    @AfterEach
//    public void cleanup(){
//        projectRepository.deleteAll();
//    }
    @Test
    public void checkPostFull(){
        //given
        LocalDateTime now = LocalDateTime.now();
        projectRepository.save(Project.builder()
                .title("hi")
                .content("testing")
//                .contentBig()
                .views(30L)
                .startDate(now)
                .endDate(now)
                .recruitmentStatus("complete")
//                .member(new Member("brian", "testing"))
                .build());

        //when
        List<Project> projectList = projectRepository.findAll();

        //then
        Project project = projectList.get(0);
        assertThat(project.getTitle().equals("hi"));
        assertThat(project.getContent().equals("testing"));
        assertThat(project.getCreatedDate().isAfter(now));
        assertThat(project.getModifiedDate().isAfter(now));
    }
}