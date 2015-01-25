package org.jboss.tools.example.springmvc.mvc;

import game.Game;
import game.GameManager;
import game.GameUtils;
import home.UserManager;
import home.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rank.Ranks;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/game")
@Controller
public class GameController {

    @Autowired
    GameManager gameManager;

    @Autowired
    UserManager userManager;

    @Autowired
    UserUtils userUtils;

	@RequestMapping(method = RequestMethod.GET)
	public String getDatas(ModelMap model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null) { return "home"; }

        int counter = (Integer) request.getSession().getAttribute("counter");
        int correctAnswers = (Integer) request.getSession().getAttribute("correctAnswers");
        int incorrectAnswers = 0;
        int totalQuestions = 0;
        int remainedQuestions = 0;

        Game game = new Game();
        gameManager.setTable((String) request.getSession().getAttribute("table"));
        gameManager.setSubject((Integer) request.getSession().getAttribute("subject"));
        gameManager.getAllDataFromCurriculum();

        totalQuestions = gameManager.getQuestion().size();
        remainedQuestions = totalQuestions - counter - 1;

        if(counter == totalQuestions) {
            return "redirect:/learn";
        }

		model.addAttribute("question", gameManager.getQuestion().get(counter));
        model.addAttribute("answer1", GameUtils.answerFilter(gameManager.getAnswer1().get(counter)));
        model.addAttribute("answer2", GameUtils.answerFilter(gameManager.getAnswer2().get(counter)));
        model.addAttribute("answer3", GameUtils.answerFilter(gameManager.getAnswer3().get(counter)));
        model.addAttribute("answer4", GameUtils.answerFilter(gameManager.getAnswer4().get(counter)));
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("incorrectAnswers", incorrectAnswers);
        model.addAttribute("remainedQuestions", remainedQuestions);
        model.addAttribute("game", game);
        model.addAttribute("curriculum", GameUtils.getCurriculum((String) request.getSession().getAttribute("table")));
        model.addAttribute("subject", request.getSession().getAttribute("subject"));
        model.addAttribute("currentStage", 100 * counter / totalQuestions);

        request.getSession().setAttribute("counter", counter);
        request.getSession().setAttribute("correctAnswers", correctAnswers);

		return "game";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String setDatas(@ModelAttribute("game") Game game, ModelMap model, HttpServletRequest request) {

        boolean answer1;
        boolean answer2;
        boolean answer3;
        boolean answer4;

        int counter = (Integer) request.getSession().getAttribute("counter");
        int correctAnswers = (Integer) request.getSession().getAttribute("correctAnswers");
        int totalQuestions = gameManager.getQuestion().size();
        int remainedQuestions = totalQuestions - counter - 2;
        int incorrectAnswers = totalQuestions - (correctAnswers + remainedQuestions + 2);


        String firstAnswer = gameManager.getAnswer1().get(counter);
        String secondAnswer = gameManager.getAnswer2().get(counter);
        String thirdAnswer = gameManager.getAnswer3().get(counter);
        String fourthAnswer = gameManager.getAnswer4().get(counter);

        answer1 = GameUtils.checkAnswer(firstAnswer, game.isAnswer1());
        answer2 = GameUtils.checkAnswer(secondAnswer, game.isAnswer2());
        answer3 = GameUtils.checkAnswer(thirdAnswer, game.isAnswer3());
        answer4 = GameUtils.checkAnswer(fourthAnswer, game.isAnswer4());

        if(answer1 && answer2 && answer3 && answer4) {
            correctAnswers++;
        }
        else {
            incorrectAnswers++;
        }

        if(counter == totalQuestions - 1) {
            String username = (String) request.getSession().getAttribute("username");
            String curriculum = (String) request.getSession().getAttribute("table");
            int subject = (Integer) request.getSession().getAttribute("subject");

            String learnStageResult = GameUtils.getLearnStageResult(curriculum, subject, Ranks.getLearnStage(counter + 1, correctAnswers));
            gameManager.updateLearnStage(learnStageResult, username);

            userUtils.setUp(request, model);
            userUtils.setRequestMethod(null);
            userUtils.putUserLeanStageOnSession();

            return "redirect:/learn";
        }

        counter++;



        model.addAttribute("question", gameManager.getQuestion().get(counter));
        model.addAttribute("answer1", GameUtils.answerFilter(gameManager.getAnswer1().get(counter)));
        model.addAttribute("answer2", GameUtils.answerFilter(gameManager.getAnswer2().get(counter)));
        model.addAttribute("answer3", GameUtils.answerFilter(gameManager.getAnswer3().get(counter)));
        model.addAttribute("answer4", GameUtils.answerFilter(gameManager.getAnswer4().get(counter)));
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("incorrectAnswers", incorrectAnswers);
        model.addAttribute("remainedQuestions", remainedQuestions);
        model.addAttribute("currentStage", 100 * counter / totalQuestions);
        model.addAttribute("curriculum", GameUtils.getCurriculum((String) request.getSession().getAttribute("table")));
        model.addAttribute("subject", request.getSession().getAttribute("subject"));

        request.getSession().setAttribute("counter", counter);
        request.getSession().setAttribute("correctAnswers", correctAnswers);
        request.getSession().setAttribute("incorrectAnswers", incorrectAnswers);
        request.getSession().setAttribute("totalQuestions", totalQuestions);
        request.getSession().setAttribute("remainedQuestions", remainedQuestions);

        return "game";
    }

}