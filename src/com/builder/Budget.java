/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Aspire
 */
public class Budget {

    static int[] processorPrice = {7407, 12030, 85650};
    static int[] cardPrice = {4971, 32312, 34151};
    static int[] drivePrice = {2088, 5965, 10340};
    static int[] ramPrice = {1392, 2784, 5965};

    static int[] processorPerformance = {6079, 7867, 20016};
    static int[] cardPerformance = {3687, 8939, 11460};
    static int[] drivePerformance = {771, 862, 1042};
    static int[] ramPerformance = {2133, 2400, 2666};

    static String[] Processors = {"i3-6320", "i5-6600K", "i7-6950X"};
    static String[] VideoCard = {"GTX 750 ti", "GTX 780 ti", "GTX 980 ti"};
    static String[] HardDrive = {"WD Caviar Blue 500gb", "WD Caviar Black 2TB", "WD Caviar Black 4TB"};
    static String[] RAM = {"Kingston 4gb DDR4 2133 mhz", "Gskill Aegis 8gb DDR4 2400 m5000hz", "Corsair Vengeance 16gb DDR4 2666mhz"};

    static int ProcessorIndex;
    static int CardIndex;
    static int DriveIndex;
    static int RamIndex;

    static List<String> Knap(int budget) {
        List<Integer> AcceptedPerformance = new ArrayList<>();
        List<String> Results = new ArrayList<>();
        List<Integer> processorIdent = new ArrayList<>();
        List<Integer> cardIdent = new ArrayList<>();
        List<Integer> driveIdent = new ArrayList<>();
        List<Integer> ramIdent = new ArrayList<>();

        for (int i = 0; i <= (processorPrice.length) - 1; ++i) {
            int a = processorPrice[i];
            int e = processorPerformance[i];
            for (int j = 0; j <= (cardPrice.length) - 1; ++j) {
                int b = cardPrice[j];
                int f = cardPerformance[j];
                for (int k = 0; k <= (drivePrice.length) - 1; ++k) {
                    int c = drivePrice[k];
                    int g = drivePerformance[k];
                    for (int l = 0; l <= (ramPrice.length) - 1; ++l) {
                        int d = ramPrice[l];
                        int h = ramPerformance[l];
                        int totalW = a + b + c + d;
                        int totalP = e + f + g + h;
                        if (totalW <= budget) {
                            AcceptedPerformance.add(totalP);
                            processorIdent.add(i);
                            cardIdent.add(j);
                            driveIdent.add(k);
                            ramIdent.add(l);
                        }

                    }

                }

            }

        }

        int maxPerformance = Collections.max(AcceptedPerformance);
        int x = AcceptedPerformance.indexOf(maxPerformance);

        ProcessorIndex = processorIdent.get(x);
        CardIndex = cardIdent.get(x);
        DriveIndex = driveIdent.get(x);
        RamIndex = ramIdent.get(x);

        Results.add(Processors[ProcessorIndex]);
        Results.add(VideoCard[CardIndex]);
        Results.add(HardDrive[DriveIndex]);
        Results.add(RAM[RamIndex]);

        return Results;
    }

    static List<Integer> totalPrice() {
        List<Integer> totalCost;
        totalCost = new ArrayList<>();
        totalCost.add(processorPrice[ProcessorIndex]);
        totalCost.add(cardPrice[CardIndex]);
        totalCost.add(drivePrice[DriveIndex]);
        totalCost.add(ramPrice[RamIndex]);

        return totalCost;
    }

    static int minimumBudget() {
        int processorPrice1;
        int cardPrice1;
        int drivePrice1;
        int ramPrice1;

        processorPrice1 = Budget.processorPrice[0];
        cardPrice1 = Budget.cardPrice[0];
        drivePrice1 = Budget.drivePrice[0];
        ramPrice1 = Budget.ramPrice[0];

        int min = processorPrice1 + cardPrice1 + drivePrice1 + ramPrice1;

        return min;
    }
}
