package org.csspec.feedback.api.controller;

import org.csspec.feedback.api.repo.AcceptedResponsesRepository;
import org.csspec.feedback.db.AcceptedResponses;
import org.csspec.feedback.db.AcceptedSingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jatinder Dhawan on 10/16/2016.
 */
@RestController
public class AcceptedResponsesController {
    @Autowired
    private AcceptedResponsesRepository acceptedResponsesRepository;

    @RequestMapping(value = "/org/csspec/feedback/response/submit", method = RequestMethod.POST)
    public void storeResponses(@RequestBody AcceptedResponses acceptedResponses) {
       // System.out.println("vfvdfbvdf");
        List<AcceptedSingleResponse> acceptedSingleResponses = acceptedResponses.getResponses();
        for(int i = 0 ;i<acceptedSingleResponses.size();i++) {
            String questionId = acceptedSingleResponses.get(i).getQuestionId();
            int response = acceptedSingleResponses.get(i).getResponse();
            acceptedResponsesRepository.updateResponseTable(acceptedResponses.getFeedbackId(),questionId,response);
        }
        System.out.println(acceptedResponses);
    }

}
