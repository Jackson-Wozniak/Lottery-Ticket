package panels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryPanelTest {

    @Test
    void makeSureAllPanelsAreNotNull(){
        LotteryPanel lotteryPanel = new LotteryPanel();
        assertNotNull(lotteryPanel.getPlayPanel());
        assertNotNull(lotteryPanel.getJackpotPanel());
        assertNotNull(lotteryPanel.getResultsPanel());
        assertNotNull(lotteryPanel.getChooseNumbersPanel());
    }

}