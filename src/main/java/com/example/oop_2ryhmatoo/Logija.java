package com.example.oop_2ryhmatoo;

public class Logija {
    private static LogiKuulaja kuulaja;

    public static void seaKuulaja(LogiKuulaja uusKuulaja) {
        kuulaja = uusKuulaja;
    }

    public static void logi(String sonum) { // Meetod sõnumite kuvamiseks GUI-s
        if (kuulaja != null) {
            kuulaja.logi(sonum);
        } else {
            System.out.println(sonum); //Juhul kui GUI-sse ei ilmu
        }
    }

    public interface LogiKuulaja {
        void logi(String sonum);
    }
}
