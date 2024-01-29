package com.example.projectvoucher.app.controller.voucher.request;

import com.example.projectvoucher.common.type.RequesterType;
import com.example.projectvoucher.common.type.VoucherAmountType;

public record VoucherPublishV2Request(
        RequesterType requesterType,
        String requesterId,
        VoucherAmountType amountType
) {
}
