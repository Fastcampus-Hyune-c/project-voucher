package com.example.projectvoucher.app.controller.employee.response;

import java.time.LocalDateTime;

public record EmployeeResponse(Long no, String name, String position, String department, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
}
