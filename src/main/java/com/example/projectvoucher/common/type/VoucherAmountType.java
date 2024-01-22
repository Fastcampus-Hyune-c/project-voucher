package com.example.projectvoucher.common.type;

public enum VoucherAmountType {
    KRW_30000(30_000L),
    KRW_50000(50_000L),
    KRW_100000(100_000L),
    ;

    private final Long amount;

    VoucherAmountType(Long amount) {
        this.amount = amount;
    }

    public Long amount() {
        return amount;
    }
}
