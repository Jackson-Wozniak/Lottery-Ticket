package lotterydrawing;

import java.util.ArrayList;
import java.util.Random;

public class CalculateLottery {

    public static ArrayList<Integer> calculateLotteryNumbers(){
        ArrayList<Integer> lotteryWinners = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            int result = random.nextInt(36) + 1;
            if(lotteryWinners.contains(result)){
                /* if current list of lottery numbers contains the random number drawn (int result),
                subtract i and re-loop. Variable i is subtracted to make sure a total of 6 numbers
                are collected
                */
                i--;
            }else{
                //if variable i is not already in the list of lottery winners, add it until there is 6
                lotteryWinners.add(result);
            }
        }
        return lotteryWinners;
    }
}
