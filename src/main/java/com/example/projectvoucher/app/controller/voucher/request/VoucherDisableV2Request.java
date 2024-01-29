package com.example.projectvoucher.app.controller.voucher.request;

import com.example.projectvoucher.common.type.RequesterType;

public record VoucherDisableV2Request(
        RequesterType requesterType,
        String requesterId,
        String code
) {
}
