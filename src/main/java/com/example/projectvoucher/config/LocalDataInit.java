package com.example.projectvoucher.config;

import com.example.projectvoucher.storage.voucher.ContractEntity;
import com.example.projectvoucher.storage.voucher.ContractRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LocalDataInit {
    private final ContractRepository contractRepository;

    public LocalDataInit(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @PostConstruct
    public void init() {
        // 계약 데이터 초기화
        contractRepository.save(new ContractEntity("CT0001", LocalDate.now().minusDays(7), LocalDate.now().plusDays(7), 366 * 5));
        contractRepository.save(new ContractEntity("CT0010", LocalDate.now().minusDays(30), LocalDate.now().minusDays(7), 366 * 5));
    }
}
