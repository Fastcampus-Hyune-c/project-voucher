package com.example.projectvoucher.domain.employee;

import com.example.projectvoucher.app.controller.response.EmployeeResponse;
import com.example.projectvoucher.storage.employee.EmployeeEntity;
import com.example.projectvoucher.storage.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 사원 생성
    public Long create(final String name, final String position, final String department) {
        final EmployeeEntity employeeEntity = employeeRepository.save(new EmployeeEntity(name, position, department));

        return employeeEntity.id();
    }

    // 사원 조회
    public EmployeeResponse get(final Long no) {
        final EmployeeEntity employeeEntity = employeeRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return new EmployeeResponse(employeeEntity.id(), employeeEntity.name(), employeeEntity.position(), employeeEntity.department(), employeeEntity.createAt(), employeeEntity.updateAt());
    }
}
