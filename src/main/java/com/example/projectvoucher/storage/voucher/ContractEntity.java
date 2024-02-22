package com.example.projectvoucher.storage.voucher;

import com.example.projectvoucher.storage.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "contract")
@Entity
public class ContractEntity extends BaseEntity {
    private String code; // 계약의 고유 코드
    private LocalDate validFrom; // 계약의 유효 기간 시작일
    private LocalDate validTo; // 계약의 유효 기간 종료일
    private Integer voucherValidPeriodDayCount; // 상품권 유효기간 일자

    public ContractEntity() {
    }

    public ContractEntity(String code, LocalDate validFrom, LocalDate validTo, Integer voucherValidPeriodDayCount) {
        this.code = code;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.voucherValidPeriodDayCount = voucherValidPeriodDayCount;
    }

    public String code() {
        return code;
    }

    public LocalDate validFrom() {
        return validFrom;
    }

    public LocalDate validTo() {
        return validTo;
    }

    public Integer voucherValidPeriodDayCount() {
        return voucherValidPeriodDayCount;
    }
}
