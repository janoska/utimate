package org.jboss.tools.example.springmvc.mvc;

import game.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jboy on 9/13/2014.
 */
 @Controller
 @RequestMapping("/inserts")
public class InsertsController {

    @Autowired
    GameManager gameManager;

    @RequestMapping(method= RequestMethod.GET)
    public String insertPage(HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null) { return "home"; }

        return "inserts";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String recoverPass(HttpServletRequest request) {
        String question = request.getParameter("question");
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        String answer3 = request.getParameter("answer3");
        String answer4 = request.getParameter("answer4");
        String curriculum = request.getParameter("curriculum");
        int subject = Integer.parseInt(request.getParameter("subject"));
        String corrAnswer1 = request.getParameter("corrAnswer1");
        String corrAnswer2 = request.getParameter("corrAnswer2");
        String corrAnswer3 = request.getParameter("corrAnswer3");
        String corrAnswer4 = request.getParameter("corrAnswer4");

        if(question != "" && answer1 != "" && answer2 != "" && answer3 != "" && answer4 != "") {
            if (corrAnswer1 != null) {
                answer1 = answer1 + "***";
            }
            if (corrAnswer2 != null) {
                answer2 = answer2 + "***";
            }
            if (corrAnswer3 != null) {
                answer3 = answer3 + "***";
            }
            if (corrAnswer4 != null) {
                answer4 = answer4 + "***";
            }

            gameManager.insertCurriculum(curriculum, subject, question, answer1, answer2, answer3, answer4);
        }

        return "inserts";

        }
}
