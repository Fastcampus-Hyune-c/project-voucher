package com.example.projectvoucher.domain.service.validator;

import com.example.projectvoucher.storage.voucher.ContractEntity;
import org.springframework.stereotype.Component;

@Component
public class VoucherPublishValidator {

    public void validate(ContractEntity contractEntity) {
        상품권_발행을_위한_계약_유효기간이_만료되었는지_확인(contractEntity);
    }

    private static void 상품권_발행을_위한_계약_유효기간이_만료되었는지_확인(ContractEntity contractEntity) {
        if (contractEntity.isExpired()) {
            throw new IllegalStateException("유효기간이 지난 계약입니다.");
        }
    }
}
