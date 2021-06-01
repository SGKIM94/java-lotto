package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PriceTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, -2341, -1})
    @DisplayName("금액은 0원이상 이어야 한다.")
    void validatePrice_test(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(price));
    }

    @ParameterizedTest
    @CsvSource({"3000, 3", "5000, 5", "4332, 4", "3941, 3"})
    @DisplayName("금액에 따른 로또 구매 가능 개수를 가져온다.")
    void calculatePerLottery_test(int inputPrice, int expectedLotteryCount) {
        //given
        Price price = new Price(inputPrice);

        //when
        int lotteryCount = price.calculatePerLottery();

        //then
        assertThat(lotteryCount).isEqualTo(expectedLotteryCount);
    }
}
