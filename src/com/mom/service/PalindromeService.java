package com.mom.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    /**
     * Determines if a given string is the same forward and backward (ie. Palindrome)
     * This method is case insensitive
     * @param toCheck the string to check, a null or empty string will return true
     */
    public boolean isPalindrome(String toCheck) {
        StringBuilder toCheckBuilder = new StringBuilder(toCheck.toLowerCase());
        return toCheck.toLowerCase().equals(toCheckBuilder.reverse().toString());
    }
}
