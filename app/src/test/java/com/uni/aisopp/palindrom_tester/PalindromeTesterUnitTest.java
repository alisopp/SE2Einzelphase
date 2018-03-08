package com.uni.aisopp.palindrom_tester;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by AIsopp on 08.03.2018.
 */
@RunWith(Parameterized.class)
public class PalindromeTesterUnitTest {

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "OOttoo", PalindromeTester.IS_PALINDROME },
                { "  OOttoo  ", PalindromeTester.IS_PALINDROME },
                { "Hello", PalindromeTester.IS_NO_PALINDROME },
                { " Hello    ", PalindromeTester.IS_NO_PALINDROME },
                { " too    ", PalindromeTester.IS_NO_PALINDROME },
                { "     ", PalindromeTester.IS_EMPTY },
                { "", PalindromeTester.IS_EMPTY},

        });
    }


    public PalindromeTesterUnitTest(String input,int result ) {
        this.result = result;
        this.input = input;
    }

    private int result;
    private String input;

    @Test
    public void testIsPalindrome(){
        Assert.assertEquals(result, PalindromeTester.isPalindrome(input));
    }

}
