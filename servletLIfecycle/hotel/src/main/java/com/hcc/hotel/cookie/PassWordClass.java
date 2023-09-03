package com.hcc.hotel.cookie;

import java.util.HashMap;

public class PassWordClass {
    public static HashMap<String, String> passWordMap = new HashMap<>();

    public static void registerUser(String userName, String passWord) {
        passWordMap.put(userName, passWord);
    }

    public static boolean verify(String userName, String passWord ) {
        String p = passWordMap.get(userName);
        if (p == null ) return false;
        return p.equals(passWord);
    }
}
