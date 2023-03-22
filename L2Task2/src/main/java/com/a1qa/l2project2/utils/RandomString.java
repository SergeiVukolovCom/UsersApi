package com.a1qa.l2project2.utils;

public class RandomString {

    public static StringBuilder getTitle() {
        StringBuilder randStringTitle = new StringBuilder();
        String latinSymbols = "abcdefghijklmnopqrstuvwxyz";
        int count = 5;
        for (int i = 0; i<count; i++) {
            randStringTitle.append(latinSymbols.charAt((int) (Math.random() * latinSymbols.length())));
        }
        return randStringTitle;
    }

    public static StringBuilder getBody() {
        StringBuilder randStringBody = new StringBuilder();
        String latinSymbols = "abcdefghijklmnopqrstuvwxyz";
        int count = 5;
        for (int i = 0; i<count; i++) {
            randStringBody.append(latinSymbols.charAt((int) (Math.random() * latinSymbols.length())));
        }
        return randStringBody;
    }

}
