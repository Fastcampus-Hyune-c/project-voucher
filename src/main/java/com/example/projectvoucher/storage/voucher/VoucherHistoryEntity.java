package com.example.projectvoucher.storage.voucher;

import com.example.projectvoucher.common.type.RequesterType;
import com.example.projectvoucher.common.type.VoucherStatusType;
import com.example.projectvoucher.storage.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Table(name = "voucher_history")
@Entity
public class VoucherHistoryEntity extends BaseEntity {
    private String orderId;
    @Enumerated(EnumType.STRING)
    private RequesterType requesterType;
    private String requesterId;
    @Enumerated(EnumType.STRING)
    private VoucherStatusType status;
    private String description;

    public VoucherHistoryEntity() {
    }

    public VoucherHistoryEntity(String orderId, RequesterType requesterType, String requesterId, VoucherStatusType status, String description) {
        this.orderId = orderId;
        this.requesterType = requesterType;
        this.requesterId = requesterId;
        this.status = status;
        this.description = description;
    }

    public String orderId() {
        return orderId;
    }

    public RequesterType requesterType() {
        return requesterType;
    }

    public String requesterId() {
        return requesterId;
    }

    public VoucherStatusType status() {
        return status;
    }

    public String description() {
        return description;
    }
}
