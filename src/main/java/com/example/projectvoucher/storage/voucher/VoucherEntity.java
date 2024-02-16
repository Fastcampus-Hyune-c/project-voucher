package com.example.projectvoucher.storage.voucher;

import com.example.projectvoucher.common.type.VoucherAmountType;
import com.example.projectvoucher.common.type.VoucherStatusType;
import com.example.projectvoucher.storage.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "voucher")
@Entity
public class VoucherEntity extends BaseEntity {
    private String code;
    @Enumerated(EnumType.STRING)
    private VoucherStatusType status;
    private LocalDate validFrom;
    private LocalDate validTo;
    @Enumerated(EnumType.STRING)
    private VoucherAmountType amount;

//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "voucher_id")
    private List<VoucherHistoryEntity> histories = new ArrayList<>();

    public VoucherEntity() {
    }

    public VoucherEntity(String code, VoucherStatusType status, LocalDate validFrom, LocalDate validTo, VoucherAmountType amount, VoucherHistoryEntity voucherHistoryEntity) {
        this.code = code;
        this.status = status;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.amount = amount;

        this.histories.add(voucherHistoryEntity);
    }

    public String code() {
        return code;
    }

    public VoucherStatusType status() {
        return status;
    }

    public LocalDate validFrom() {
        return validFrom;
    }

    public LocalDate validTo() {
        return validTo;
    }

    public VoucherAmountType amount() {
        return amount;
    }

    public List<VoucherHistoryEntity> histories() {
        return histories;
    }

    public void disable() {
        if (!this.status.equals(VoucherStatusType.PUBLISH)) {
            throw new IllegalStateException("사용 불가 처리할 수 없는 상태의 상품권 입니다.");
        }

        this.status = VoucherStatusType.DISABLE;
    }

    public void use() {
        if (!this.status.equals(VoucherStatusType.PUBLISH)) {
            throw new IllegalStateException("사용할 수 없는 상태의 상품권 입니다.");
        }

        this.status = VoucherStatusType.USE;
    }
}
