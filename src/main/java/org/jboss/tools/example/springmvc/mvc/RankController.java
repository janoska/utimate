package org.jboss.tools.example.springmvc.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rank.RankManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by jboy on 9/13/2014.
 */
@Controller
@RequestMapping("/rank")
public class RankController {

    @Autowired
    RankManager rankManager;

    @RequestMapping(method = RequestMethod.GET)
    public String rank(ModelMap model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null) { return "home"; }

    rankManager.getAllUsersForRank();

        ArrayList<String> name = rankManager.getName();
        ArrayList<Integer> romana = rankManager.getRomana();

        model.addAttribute("name", name);
        model.addAttribute("level", romana);
        model.addAttribute("selectedValue", "romana");

        return "rank";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String ranks(ModelMap model, HttpServletRequest request) {
        String curriculum = request.getParameter("curriculums");

        rankManager.getAllUsersForRank();
        ArrayList<String> name = rankManager.getName();
        ArrayList<Integer> romana = rankManager.getRomana();
        ArrayList<Integer> istorie = rankManager.getIstorie();
        ArrayList<Integer> geografie = rankManager.getGeografie();
        ArrayList<Integer> biologie = rankManager.getBiologie();
        ArrayList<Integer> anatomie = rankManager.getAnatomie();

//        switch (curriculum) {
//            case "romana": model.addAttribute("name", name);
//                           model.addAttribute("level", romana);
//                           model.addAttribute("selectedValue", curriculum);
//                           return "rank";
//            case "istorie": model.addAttribute("name", name);
//                            model.addAttribute("level", istorie);
//                            model.addAttribute("selectedValue", curriculum);
//                            return "rank";
//            case "geografie": model.addAttribute("name", name);
//                              model.addAttribute("level", geografie);
//                              model.addAttribute("selectedValue", curriculum);
//                              return "rank";
//            case "biologie": model.addAttribute("name", name);
//                             model.addAttribute("level", biologie);
//                             model.addAttribute("selectedValue", curriculum);
//                             return "rank";
//            case "anatomie": model.addAttribute("name", name);
//                             model.addAttribute("level", anatomie);
//                             model.addAttribute("selectedValue", curriculum);
//                             return "rank";
//            default: model.addAttribute("name", name);
//                     model.addAttribute("level", romana);
//                     return "rank";
//        }
        return "home";
    }
}
