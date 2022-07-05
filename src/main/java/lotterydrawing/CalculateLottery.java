package lotterydrawing;

import java.util.ArrayList;
import java.util.Random;

public class CalculateLottery {

    private final ArrayList<Integer> lotteryWinners = new ArrayList<>();

    public CalculateLottery(){
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            int result = random.nextInt(36) + 1;
            if(lotteryWinners.contains(result)){
                i--;
            }else{
                lotteryWinners.add(result);
            }
        }
    }

    public ArrayList<Integer> getLotteryWinners(){
        return lotteryWinners;
    }
}
