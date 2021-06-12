package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualLotteriesTest {


    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 5})
    @DisplayName("수동 로또인 경우 0개 미만이거나 총 로또개수를 초과하면 안된다.")
    void validateManualLotteriesCount_test(int countOfManualLotteries) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLotteries.validateGenerateCount(4, countOfManualLotteries)
        );
    }

    @Test
    @DisplayName("수동 로또를 입력한 숫자로 생성한다.")
    void generateManualLotteries_test() {
        //given
        List<LotteryNumbers> lotteryNumbers = List.of(
                new LotteryNumbers(List.of(10, 15, 24, 39, 40, 45)),
                new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6))
        );

        //when
        ManualLotteries manualLotteries = new ManualLotteries(lotteryNumbers);

        //then
        assertThat(manualLotteries.size()).isEqualTo(2);
    }
}
