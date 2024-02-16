package com.example.projectvoucher.domain.service;

import com.example.projectvoucher.common.dto.RequestContext;
import com.example.projectvoucher.common.type.RequesterType;
import com.example.projectvoucher.common.type.VoucherAmountType;
import com.example.projectvoucher.common.type.VoucherStatusType;
import com.example.projectvoucher.storage.voucher.VoucherEntity;
import com.example.projectvoucher.storage.voucher.VoucherHistoryEntity;
import com.example.projectvoucher.storage.voucher.VoucherRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VoucherServiceV2Test {
    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherRepository voucherRepository;

    @DisplayName("발행된 상품권은 code 로 조회할 수 있어야 된다.")
    @Test
    public void test1() {
        // given
        final RequestContext requestContext = new RequestContext(RequesterType.PARTNER, UUID.randomUUID().toString());
        final LocalDate validFrom = LocalDate.now();
        final LocalDate validTo = LocalDate.now().plusDays(30);
        final VoucherAmountType amount = VoucherAmountType.KRW_30000;

        final String code = voucherService.publishV2(requestContext, validFrom, validTo, amount);

        // when
        final VoucherEntity voucherEntity = voucherRepository.findByCode(code).get();

        // then
        assertThat(voucherEntity.code()).isEqualTo(code);
        assertThat(voucherEntity.status()).isEqualTo(VoucherStatusType.PUBLISH);
        assertThat(voucherEntity.validFrom()).isEqualTo(validFrom);
        assertThat(voucherEntity.validTo()).isEqualTo(validTo);
        assertThat(voucherEntity.amount()).isEqualTo(amount);

        // history
        final VoucherHistoryEntity voucherHistoryEntity = voucherEntity.histories().get(0);
        assertThat(voucherHistoryEntity.orderId()).isNotNull();
        assertThat(voucherHistoryEntity.requesterType()).isEqualTo(requestContext.requesterType());
        assertThat(voucherHistoryEntity.requesterId()).isEqualTo(requestContext.requesterId());
        assertThat(voucherHistoryEntity.status()).isEqualTo(VoucherStatusType.PUBLISH);
        assertThat(voucherHistoryEntity.description()).isEqualTo("테스트 발행");
    }

    @DisplayName("발행된 상품권은 사용 불가 처리 할 수 있다.")
    @Test
    public void test2() {
        // given
        final RequestContext requestContext = new RequestContext(RequesterType.PARTNER, UUID.randomUUID().toString());
        final LocalDate validFrom = LocalDate.now();
        final LocalDate validTo = LocalDate.now().plusDays(30);
        final VoucherAmountType amount = VoucherAmountType.KRW_30000;

        final String code = voucherService.publishV2(requestContext, validFrom, validTo, amount);

        // when
        voucherService.disable(code);
        final VoucherEntity voucherEntity = voucherRepository.findByCode(code).get();

        // then
        assertThat(voucherEntity.code()).isEqualTo(code);
        assertThat(voucherEntity.status()).isEqualTo(VoucherStatusType.DISABLE);
        assertThat(voucherEntity.validFrom()).isEqualTo(validFrom);
        assertThat(voucherEntity.validTo()).isEqualTo(validTo);
        assertThat(voucherEntity.amount()).isEqualTo(amount);
        assertThat(voucherEntity.updateAt()).isNotEqualTo(voucherEntity.createAt());

        System.out.println("### voucherEntity.createAt() = " + voucherEntity.createAt());
        System.out.println("### voucherEntity.updateAt() = " + voucherEntity.updateAt());
    }

    @DisplayName("발행된 상품권은 사용할 수 있다.")
    @Test
    public void test3() {
        // given
        final RequestContext requestContext = new RequestContext(RequesterType.PARTNER, UUID.randomUUID().toString());
        final LocalDate validFrom = LocalDate.now();
        final LocalDate validTo = LocalDate.now().plusDays(30);
        final VoucherAmountType amount = VoucherAmountType.KRW_30000;

        final String code = voucherService.publishV2(requestContext, validFrom, validTo, amount);

        // when
        voucherService.use(code);
        final VoucherEntity voucherEntity = voucherRepository.findByCode(code).get();

        // then
        assertThat(voucherEntity.code()).isEqualTo(code);
        assertThat(voucherEntity.status()).isEqualTo(VoucherStatusType.USE);
        assertThat(voucherEntity.validFrom()).isEqualTo(validFrom);
        assertThat(voucherEntity.validTo()).isEqualTo(validTo);
        assertThat(voucherEntity.amount()).isEqualTo(amount);
        assertThat(voucherEntity.updateAt()).isNotEqualTo(voucherEntity.createAt());

        System.out.println("### voucherEntity.createAt() = " + voucherEntity.createAt());
        System.out.println("### voucherEntity.updateAt() = " + voucherEntity.updateAt());
    }
}
