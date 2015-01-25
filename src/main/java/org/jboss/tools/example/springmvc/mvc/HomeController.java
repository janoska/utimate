package org.jboss.tools.example.springmvc.mvc;

import home.Register;
import home.UserManager;
import home.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jboy on 9/13/2014.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserManager userManager;

    @Autowired
    UserUtils userUtils;

    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, ModelMap model,
                       @RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout) {

        if (error != null) {
            model.addAttribute("error", "Nume utilizator sau parola gre&#x219it&#259!");
        }
        if (request.getUserPrincipal() != null &&
                request.getUserPrincipal().getName() != request.getSession().getAttribute("username")) {
            userUtils.setUp(request, null);
            userUtils.setRequestMethod(null);
            userUtils.putUserInfoOnSession();
            userUtils.putUserLeanStageOnSession();

        }

        return "home";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model, @ModelAttribute("register") Register user) {

        userManager.register(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserName(), user.getPassword(),
                1, "Necompletat", "Necompletat", "Necompletat", "Necompletat", "/resources/img/student.jpg");


        return "home";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String home(HttpServletRequest request, Model model) {

        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        String mail = request.getParameter("mail");

        if (mail != null) {

            request.getSession().setAttribute("username", mail);

            userUtils.setUp(request, null);
            userUtils.setRequestMethod(null);
            userUtils.putUserInfoOnSession();
            userUtils.putUserLeanStageOnSession();

            List<String> userInfo = new ArrayList<String>();
            userInfo.addAll(userManager.getUserInfo(mail));
            if(userInfo.size() == 0){
                userManager.register(fName, lName, mail, mail, "password", 1, "Necompletat",
                        "Necompletat", "Necompletat", "Necompletat", "/resources/img/student.jpg");
            }
                model.addAttribute("username", mail);
                return "home";
        }

        return "home";
    }

}