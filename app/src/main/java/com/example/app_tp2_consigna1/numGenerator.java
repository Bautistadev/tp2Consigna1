package com.example.app_tp2_consigna1;

public class numGenerator {
    public static Integer getRandomNum(){

        Integer random = (int)(Math.random()*100);

        if(random >= 0 && random < 20)
            return 1;
        else if(random >= 20 && random < 40)
            return 2;
        else if(random >= 40 && random < 60)
            return 3;
        else if(random >= 60 && random < 80)
            return 4;
        else
            return 5;
    }
}
