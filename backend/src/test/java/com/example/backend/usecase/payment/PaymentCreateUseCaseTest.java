package com.example.backend.usecase.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.PointHistoryRepository;
import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.UserRepository;
import com.example.backend.shared.TestUserFactory;
import com.example.backend.usecase.payment.PaymentCreateParam.PaymentDetailParam;
import com.example.backend.usecase.payment.PaymentCreateParam.PaymentMethodDetailParam;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) public class PaymentCreateUseCaseTest {
    // 依存オブジェクトのモック
    @Mock private PaymentRepository paymentRepository;
    @Mock private PointHistoryRepository pointHistoryRepository;
    @Mock private UserRepository userRepository;

    // テスト対象
    @InjectMocks private PaymentCreateUseCase paymentCreateUseCase;

    // テストデータ(全テストで共通) TODO 後でFactoryクラス作る
    private static String userId = "0000000001";
    private static User user = TestUserFactory.create(userId);

    @Test public void 支払とポイント履歴を渡すとそれぞれ登録してレシートIDが返却される() {


        // given(前提条件)：
        // ユーザ検索時に事前に定義したユーザ情報を常に返すようにモック定義
        when(userRepository.findById(userId)).thenReturn(user);

        // 支払情報登録時、ポイント履歴登録時にリポジトリに渡された情報をキャプチャするやつ
        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        ArgumentCaptor<PointHistory> pointHistoryCaptor =
                ArgumentCaptor.forClass(PointHistory.class);

        // ユースケースに渡すParam TODO 後でFactory作る
        PaymentCreateParam param = PaymentCreateParam.builder().receiptId("0000000003")
                .paymentDate(LocalDate.of(2021, 1, 1)).usagePoint(200).paymentPrice(6000)
                .grantTarget(true).paymentDetails(Arrays.asList(
                        PaymentDetailParam.builder().itemName("○○本").unitPrice(3000).build()))
                .paymentMethodDetails(Arrays.asList(
                        PaymentMethodDetailParam.builder().paymentMethodName("電子マネー")
                                .paymentAmount(2800).build())).userId("0000000001").build();


        // when(操作)：
        String result = paymentCreateUseCase.execute(param);

        // リポジトリが登録しようとした時の(リポジトリに受け渡された)支払、ポイント履歴を取得
        verify(paymentRepository).insert(paymentCaptor.capture());
        verify(pointHistoryRepository).insert(pointHistoryCaptor.capture());
        Payment actualPayment = paymentCaptor.getValue();
        PointHistory actualPointHistory = pointHistoryCaptor.getValue();


        // then(期待する結果):
        // ユースケース(依存オブジェクトモックで)実行した結果の期待値確認
        assertEquals(param.getReceiptId(), result);

        // ユースケースが依存するリポジトリに受け渡した期待値確認(ちょっと省略してる)
        assertEquals(param.getReceiptId(), actualPayment.receiptId);
        assertEquals(param.getPaymentPrice(), actualPayment.paymentPrice.value);
        assertEquals(param.getPaymentDate(), actualPayment.paymentDate.value);
        assertEquals(param.getPaymentDetails().get(0).getUnitPrice(),
                actualPayment.paymentDetails.get(0).unitPrice.value);
        assertEquals(param.getPaymentDetails().get(0).getItemName(),
                actualPayment.paymentDetails.get(0).itemName);

        assertEquals(param.getReceiptId(), actualPointHistory.receiptId);
        assertEquals(param.getUsagePoint(), actualPointHistory.usagePoint.value);
        assertEquals(param.getPaymentDate(), actualPointHistory.pointUsageDate.value);
        assertEquals(param.getUserId(), actualPointHistory.userId);
    }

}
