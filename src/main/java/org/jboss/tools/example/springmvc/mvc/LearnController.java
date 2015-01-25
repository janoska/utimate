package org.jboss.tools.example.springmvc.mvc;

import game.GameManager;
import game.GameUtils;
import home.UserManager;
import home.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rank.Ranks;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sara on 22.11.2014.
 */

@Controller
@RequestMapping("/learn")
public class LearnController  {

    @Autowired
    GameManager gameManager;

    @Autowired
    UserManager userManager;

    @Autowired
    UserUtils userUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String learn(ModelMap model, HttpServletRequest request) {
    if(request.getSession().getAttribute("username") == null) { return "home"; }

    userUtils.setUp(request, model);
    userUtils.setRequestMethod("GET");
    userUtils.putUserLeanStageOnSession();

        return "learn";

    }

    @RequestMapping(value = "/starting", method = RequestMethod.POST)
    public String setDatas(HttpServletRequest request) {
        String material = request.getParameter("material");

//        switch (material) {
//            case "romana1": request.getSession().setAttribute("table", "romana");
//                request.getSession().setAttribute("subject", 1);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("romanaStageSubICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("romanaStageSubICounterAndCorr")));
//                return "redirect:/game";
//            case "romana3": request.getSession().setAttribute("table", "romana");
//                request.getSession().setAttribute("subject", 3);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("romanaStageSubIIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("romanaStageSubIIICounterAndCorr")));
//                return "redirect:/game";
//            case "istorie1": request.getSession().setAttribute("table", "istorie");
//                request.getSession().setAttribute("subject", 1);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("istorieStageSubICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("istorieStageSubICounterAndCorr")));
//                return "redirect:/game";
//            case "istorie3": request.getSession().setAttribute("table", "istorie");
//                request.getSession().setAttribute("subject", 3);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("istorieStageSubIIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("istorieStageSubIIICounterAndCorr")));
//                return "redirect:/game";
//            case "geografie1": request.getSession().setAttribute("table", "geografie");
//                request.getSession().setAttribute("subject", 1);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("geografieStageSubICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("geografieStageSubICounterAndCorr")));
//                return "redirect:/game";
//            case "geografie2": request.getSession().setAttribute("table", "geografie");
//                request.getSession().setAttribute("subject", 2);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("geografieStageSubIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("geografieStageSubIICounterAndCorr")));
//                return "redirect:/game";
//            case "geografie3": request.getSession().setAttribute("table", "geografie");
//                request.getSession().setAttribute("subject", 3);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("geografieStageSubIIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("geografieStageSubIIICounterAndCorr")));
//                return "redirect:/game";
//            case "biologie1": request.getSession().setAttribute("table", "biologie");
//                request.getSession().setAttribute("subject", 1);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("biologieStageSubICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("biologieStageSubICounterAndCorr")));
//                return "redirect:/game";
//            case "biologie2": request.getSession().setAttribute("table", "biologie");
//                request.getSession().setAttribute("subject", 2);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("biologieStageSubIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("biologieStageSubIICounterAndCorr")));
//                return "redirect:/game";
//            case "biologie3": request.getSession().setAttribute("table", "biologie");
//                request.getSession().setAttribute("subject", 3);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("biologieStageSubIIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("biologieStageSubIIICounterAndCorr")));
//                return "redirect:/game";
//            case "anatomie1": request.getSession().setAttribute("table", "anatomie");
//                request.getSession().setAttribute("subject", 1);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("anatomieStageSubICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("anatomieStageSubICounterAndCorr")));
//                return "redirect:/game";
//            case "anatomie2": request.getSession().setAttribute("table", "anatomie");
//                request.getSession().setAttribute("subject", 2);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("anatomieStageSubIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("anatomieStageSubIICounterAndCorr")));
//                return "redirect:/game";
//            case "anatomie3": request.getSession().setAttribute("table", "anatomie");
//                request.getSession().setAttribute("subject", 3);
//                request.getSession().setAttribute("counter", Ranks.getFirstElement((String) request.getSession().getAttribute("anatomieStageSubIIICounterAndCorr")));
//                request.getSession().setAttribute("correctAnswers", Ranks.getSecondElement((String) request.getSession().getAttribute("anatomieStageSubIIICounterAndCorr")));
//                return "redirect:/game";
//
//            default: return "/game";
//        }
        return "home";
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public String stop(ModelMap model, HttpServletRequest request) {

        String username = (String) request.getSession().getAttribute("username");
        int counter = (Integer) request.getSession().getAttribute("counter");
        int correctAnswers = (Integer) request.getSession().getAttribute("correctAnswers");
        String curriculum = (String) request.getSession().getAttribute("table");
        int subject = (Integer) request.getSession().getAttribute("subject");

        String learnStageResult = GameUtils.getLearnStageResult(curriculum, subject, Ranks.getLearnStage(counter, correctAnswers));
        gameManager.updateLearnStage(learnStageResult, username);

        userUtils.setUp(request, model);
        userUtils.setRequestMethod(null);
        userUtils.putUserLeanStageOnSession();

        return "learn";
    }

}
