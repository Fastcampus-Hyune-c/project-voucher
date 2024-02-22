package com.example.projectvoucher.storage.voucher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    Optional<ContractEntity> findByCode(String code);
}
