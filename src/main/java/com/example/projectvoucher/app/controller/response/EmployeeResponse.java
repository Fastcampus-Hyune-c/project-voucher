package com.example.projectvoucher.app.controller.response;

import java.time.LocalDateTime;

public record EmployeeResponse(Long no, String name, String position, String department, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
}
