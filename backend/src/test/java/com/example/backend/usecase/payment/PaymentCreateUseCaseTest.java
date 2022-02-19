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
import com.example.backend.shared.TestPaymentFactory;
import com.example.backend.shared.TestPointHistoryFactory;
import com.example.backend.shared.TestUserFactory;
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
    private static PointHistory pointHistory = TestPointHistoryFactory.create(userId);

    @Test public void 支払とポイント履歴を渡すとそれぞれ登録してレシートIDが返却される() {


        // given(前提条件)：
        // ユーザ検索時に事前に定義したユーザ情報を常に返すようにモック定義
        when(userRepository.findById(userId)).thenReturn(user);

        // 支払情報登録時、ポイント履歴登録時にリポジトリに渡された情報をキャプチャするやつ
        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        ArgumentCaptor<PointHistory> pointHistoryCaptor =
                ArgumentCaptor.forClass(PointHistory.class);

        // 支払エンティティをユーザIDだけ個別設定(他はデフォルト値)で生成
        Payment payment = TestPaymentFactory.create(userId);


        // when(操作)：
        String result = paymentCreateUseCase.execute(payment, pointHistory);

        // リポジトリが登録しようとした時の(リポジトリに受け渡された)支払、ポイント履歴を取得
        verify(paymentRepository).insert(paymentCaptor.capture());
        verify(pointHistoryRepository).insert(pointHistoryCaptor.capture());
        Payment actualPayment = paymentCaptor.getValue();
        PointHistory actualPointHistory = pointHistoryCaptor.getValue();


        // then(期待する結果):
        // ユースケース(依存オブジェクトモックで)実行した結果の期待値確認
        assertEquals(payment.receiptId, result);

        // ユースケースが依存するリポジトリに受け渡した期待値確認(ちょっと省略してる)
        assertEquals(payment.receiptId, actualPayment.receiptId);
        assertEquals(payment.paymentPrice.value, actualPayment.paymentPrice.value);
        assertEquals(payment.paymentDate.value, actualPayment.paymentDate.value);
        assertEquals(payment.paymentDetails.get(0).unitPrice.value, actualPayment.paymentDetails.get(0).unitPrice.value);
        assertEquals(payment.paymentDetails.get(0).itemName, actualPayment.paymentDetails.get(0).itemName);

        assertEquals(pointHistory.receiptId, actualPointHistory.receiptId);
        assertEquals(pointHistory.usagePoint.value, actualPointHistory.usagePoint.value);
        assertEquals(pointHistory.pointUsageDate.value, actualPointHistory.pointUsageDate.value);
        assertEquals(pointHistory.userId, actualPointHistory.userId);
    }

}
