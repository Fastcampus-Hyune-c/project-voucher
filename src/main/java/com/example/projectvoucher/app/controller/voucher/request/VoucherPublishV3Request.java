package com.example.projectvoucher.app.controller.voucher.request;

import com.example.projectvoucher.common.type.RequesterType;
import com.example.projectvoucher.common.type.VoucherAmountType;

public record VoucherPublishV3Request(
        RequesterType requesterType,
        String requesterId,
        String contractCode,
        VoucherAmountType amountType
) {
}
