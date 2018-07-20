package com.mom.controller;

import com.mom.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.mom.controller.ResumeController.RESUME_RESOURCE;

@RequestMapping(RESUME_RESOURCE)
@Controller
public class ResumeController {

    public static final String RESUME_RESOURCE = "resume";

    @Autowired private ResumeService resumeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getResumeLowerCase() {
        ModelAndView mav = new ModelAndView("resume");
        List<String> resumeLines = resumeService.getResume();

        List<String> topics = resumeLines.stream()
                .filter(line -> line.length() < 20)
                .collect(Collectors.toList());

        mav.addObject("topics", topics);

        mav.addObject("lines", resumeLines);

        return mav;
    }
}
