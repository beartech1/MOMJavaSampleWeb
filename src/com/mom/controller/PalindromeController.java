package com.mom.controller;

import com.mom.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

import static com.mom.controller.PalindromeController.PALINDROME_RESOURCE;

@RequestMapping(PALINDROME_RESOURCE)
@Controller
public class PalindromeController {

    public static final String PALINDROME_RESOURCE = "isPalindrome";

    @Autowired private PalindromeService palindromeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPalindromeResponse(@RequestParam String input) {
        boolean isPalindrome = palindromeService.isPalindrome(input);
        LocalDateTime now = LocalDateTime.now();
        StringBuilder response = new StringBuilder()
                .append(now.getMonthValue())
                .append('/')
                .append(now.getDayOfMonth())
                .append('/')
                .append(now.getYear())
                .append(' ')
                .append(now.getHour())
                .append(':')
                .append(now.getMinute())
                .append(' ');
        response.append(input);
        if (isPalindrome) {
            response.append(" is a palindrome");
        } else {
            response.append(" is not a palindrome");
        }

        ModelAndView mav = new ModelAndView("palindrome");
        mav.addObject("msg", response.toString());
        return mav;
    }
}
