package com.example.projectvoucher;

import com.example.projectvoucher.app.controller.employee.response.EmployeeResponse;
import com.example.projectvoucher.domain.employee.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @DisplayName("회원 생성 후 조회가 가능하다.")
    @Test
    public void test1(){
        // given
        String name = "홍길동";
        String position = "사원";
        String department = "개발팀";

        // when
        Long no = employeeService.create(name, position, department);
        EmployeeResponse response = employeeService.get(no);

        // then
        assertThat(response).isNotNull();
        assertThat(response.no()).isEqualTo(no);
        assertThat(response.name()).isEqualTo(name);
        assertThat(response.position()).isEqualTo(position);
        assertThat(response.department()).isEqualTo(department);
    }
}
