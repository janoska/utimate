package org.jboss.tools.example.springmvc.mvc;

import home.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import profile.ProfileManager;
import rank.Ranks;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jboy on 9/13/2014.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserManager userManager;

    @Autowired
    ProfileManager profileManager;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(ModelMap model, HttpServletRequest request) {
        if(request.getSession().getAttribute("username") == null) { return "home"; }

        String romSubs = (String) request.getSession().getAttribute("romSubs");
        String istSubs = (String) request.getSession().getAttribute("istSubs");
        String geoSubs = (String) request.getSession().getAttribute("geoSubs");
        String bioSubs = (String) request.getSession().getAttribute("bioSubs");
        String anaSubs = (String) request.getSession().getAttribute("anaSubs");
        List<String> profileInfo = new ArrayList<String>();
        profileInfo.addAll((Collection<? extends String>) request.getSession().getAttribute("userInfo"));
        profileInfo.addAll((Collection<? extends String>) request.getSession().getAttribute("userLearnStage"));
        String school = profileInfo.get(6);
        String city = profileInfo.get(7);
        String judet = profileInfo.get(8);
        String bac = profileInfo.get(9);
        String image = profileInfo.get(10);
        String romanaSubIStage = profileInfo.get(13);
        String romanaSubIIIStage = profileInfo.get(14);
        String istorieSubIStage = profileInfo.get(15);
        String istorieSubIIIStage = profileInfo.get(16);
        String geografieSubIStage = profileInfo.get(17);
        String geografieSubIIStage = profileInfo.get(18);
        String geografieSubIIIStage = profileInfo.get(19);
        String biologieSubIStage = profileInfo.get(20);
        String biologieSubIIStage = profileInfo.get(21);
        String biologieSubIIIStage = profileInfo.get(22);
        String anatomieSubIStage = profileInfo.get(23);
        String anatomieSubIIStage = profileInfo.get(24);
        String anatomieSubIIIStage = profileInfo.get(25);

        model.addAttribute("school", school);
        model.addAttribute("city", city);
        model.addAttribute("judet", judet);
        model.addAttribute("bac", bac);
        model.addAttribute("image", image);

        int romSubISum = Ranks.getRankSubs(Ranks.getFirstElement(romanaSubIStage), Ranks.getFirstElement(romSubs));
        int romSubIIISum = Ranks.getRankSubs(Ranks.getFirstElement(romanaSubIIIStage), Ranks.getSecondElement(romSubs));
        int istSubISum = Ranks.getRankSubs(Ranks.getFirstElement(istorieSubIStage), Ranks.getFirstElement(istSubs));
        int istSubIIISum = Ranks.getRankSubs(Ranks.getFirstElement(istorieSubIIIStage), Ranks.getSecondElement(istSubs));
        int geoSubISum = Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIStage), Ranks.getFirstElement(geoSubs));
        int geoSubIISum = Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIIStage), Ranks.getSecondElement(geoSubs));
        int geoSubIIISum = Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIIIStage), Ranks.getThirdElement(geoSubs));
        int bioSubISum = Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIStage), Ranks.getFirstElement(bioSubs));
        int bioSubIISum = Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIIStage), Ranks.getSecondElement(bioSubs));
        int bioSubIIISum = Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIIIStage), Ranks.getThirdElement(bioSubs));
        int anaSubISum = Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIStage), Ranks.getFirstElement(anaSubs));
        int anaSubIISum = Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIIStage), Ranks.getSecondElement(anaSubs));
        int anaSubIIISum = Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIIIStage), Ranks.getThirdElement(anaSubs));

        model.addAttribute("romanaStage", Ranks.getRankRomIst(romSubISum, romSubIIISum));
        model.addAttribute("istorieStage", Ranks.getRankRomIst(istSubISum, istSubIIISum));
        model.addAttribute("geografieStage", Ranks.getRankGeoBio(geoSubISum, geoSubIISum, geoSubIIISum));
        model.addAttribute("biologieStage", Ranks.getRankGeoBio(bioSubISum, bioSubIISum, bioSubIIISum));
        model.addAttribute("anatomieStage", Ranks.getRankGeoBio(anaSubISum, anaSubIISum, anaSubIIISum));

        return "profile";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("editProfile") Object object, HttpServletRequest request, ModelMap model) {

        String scoala = request.getParameter("scoala");
        String oras = request.getParameter("oras");
        String judet = request.getParameter("judet");
        String bac = request.getParameter("bac");
        String username = (String) request.getSession().getAttribute("username");
        String image = "/resources/img/student.jpg";

        profileManager.setProfileInfo(image, scoala, oras, judet, bac, username);

        ArrayList<String> profileInfo = userManager.getUserInfo(username);
        profileInfo.set(6, scoala);
        profileInfo.set(7, oras);
        profileInfo.set(8, judet);
        profileInfo.set(9, bac);
        profileInfo.set(10, image);

        request.getSession().setAttribute("userInfo", profileInfo);


        model.addAttribute("school", scoala);
        model.addAttribute("city", oras);
        model.addAttribute("judet", judet);
        model.addAttribute("bac", bac);
        model.addAttribute("image", image);

        return "profile";

    }
}
