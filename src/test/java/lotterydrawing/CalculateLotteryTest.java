package lotterydrawing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculateLotteryTest {

    @Test
    void lotteryWinnersListMaxLengthOf6(){
        CalculateLottery calculateLottery = new CalculateLottery();
        ArrayList<Integer> testArray = calculateLottery.getLotteryWinners();
        assertEquals(6, testArray.size());
    }
}