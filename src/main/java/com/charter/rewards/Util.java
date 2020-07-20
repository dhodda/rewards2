package com.charter.rewards;

public class Util {
    public static double calcRewardsPerTx(double amount) {
        if (amount > 100)
            return (amount - 100) * 2 + 50;
        else if (amount > 50 && amount <= 100)
            return amount - 50;
        else return 0;
    }

}
