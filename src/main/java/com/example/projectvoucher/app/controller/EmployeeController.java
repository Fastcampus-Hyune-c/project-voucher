package com.example.projectvoucher.app.controller;

import com.example.projectvoucher.app.controller.request.EmployeeCreateRequest;
import com.example.projectvoucher.app.controller.response.EmployeeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    private final Map<Long, EmployeeResponse> employeeResponseMap = new HashMap<>();

    // 사원 생성
    @PostMapping("/api/v1/employee")
    public Long create(@RequestBody final EmployeeCreateRequest request) {
        Long no = employeeResponseMap.size() + 1L;
        employeeResponseMap.put(no, new EmployeeResponse(no, request.name(), request.position(), request.department()));

        return no;
    }

    // 사원 조회
    @GetMapping("/api/v1/employee/{no}")
    public EmployeeResponse get(@PathVariable final Long no) {
        return employeeResponseMap.get(no);
    }
}
