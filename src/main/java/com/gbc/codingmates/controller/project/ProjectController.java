package com.gbc.codingmates.controller.project;

import com.gbc.codingmates.dto.project.ProjectRequestDto;
import com.gbc.codingmates.dto.project.ProjectResponseDto;
import com.gbc.codingmates.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final Mapper mapper;

    //list all projects
    @GetMapping("")
    public ResponseEntity<List<ProjectResponseDto>> findAll(){
        return projectService.findAll();
    }

    //create project
    @PostMapping("")
    public ResponseEntity<Long> save(@RequestBody final ProjectRequestDto projectRequestDto) {
        return projectService.save(projectRequestDto);

    }

    //edit/update project
    @PatchMapping("/{id}")
    @PutMapping("{id}")
    public ResponseEntity<Long> edit(@PathVariable final Long id, @RequestBody final ProjectRequestDto projectRequestDto){
        return projectService.update(id, projectRequestDto);
    }

    //delete project
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id, @RequestBody final ProjectRequestDto projectRequestDto){
        projectService.deleteById(id, projectRequestDto);
    }


}
