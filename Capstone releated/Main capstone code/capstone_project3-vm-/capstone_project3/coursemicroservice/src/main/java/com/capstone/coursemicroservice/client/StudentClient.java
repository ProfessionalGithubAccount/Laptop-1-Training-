package com.capstone.coursemicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name="gatesecurity")
public interface StudentClient {
    @GetMapping("/students/{studentId}/courses")
    List<Integer> getCIDBySID(@PathVariable Integer studentId);
    @GetMapping("/professor/{professorId}/courses")
    List<Integer> getCIDByPID(@PathVariable Integer professorId);
}