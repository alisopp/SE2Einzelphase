package com.uni.aisopp.palindrom_tester;

/**
 * Class for checking if input is a palindrome
 *
 * @author AIsopp
 * @since 08.03.2018
 */
public class PalindromeTester {
    public static final int IS_EMPTY = 0;
    public static final int IS_LESS_THAN_FIVE = 1;
    public static final int IS_PALINDROME = 2;
    public static final int IS_NO_PALINDROME = 3;

    /**
     * tests if the given string is a palindrome
     * @param str the string to check
     * @return
     * {@value #IS_EMPTY} ({@link #IS_EMPTY}) if str is empty,
     * {@value #IS_LESS_THAN_FIVE} ({@link #IS_LESS_THAN_FIVE}) if str length is less than five (length without space chars),
     * {@value #IS_PALINDROME} ({@link #IS_PALINDROME}) if str is a palindrome,
     * {@value #IS_NO_PALINDROME} ({@link #IS_NO_PALINDROME}) if str is no palindrome,
     */
    public static int isPalindrome(String str) {
        if (str.matches(" *")){
            return IS_EMPTY;
        }

        str = str.toLowerCase();
        if(str.length() < 5){
            return IS_LESS_THAN_FIVE;
        }

        if(str.equals(new StringBuilder(str).reverse().toString())){
            return IS_PALINDROME;
        }else{
            return IS_NO_PALINDROME;
        }
    }
}
