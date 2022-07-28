package lotterydrawing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLotteryTest {

    @Test
    void lotteryWinnersListMaxLengthOf6(){
        ArrayList<Integer> testArray = CalculateLottery.calculateLotteryNumbers();
        assertEquals(6, testArray.size());
    }
}