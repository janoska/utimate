package home;

import game.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import rank.Ranks;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by sara on 20.12.2014.
 */

public class UserUtils {

    private HttpServletRequest request;
    private ModelMap model;
    private String requestMethod;

    @Autowired
    UserManager userManager;

    @Autowired
    GameManager gameManager;

    public void setUp(HttpServletRequest request, ModelMap modelMap) {
        this.request = request;
        this.model = modelMap;
    }

    public void putUserLeanStageOnSession() {
        ArrayList<String> userLearnStage;

        if(requestMethod == null) {
            userLearnStage = userManager.getUserLearnStageInfo(username());
        } else {
            userLearnStage = (ArrayList<String>) request.getSession().getAttribute("userLearnStage");
        }

        String romanaSubIStage = userLearnStage.get(2);
        String romanaSubIIIStage = userLearnStage.get(3);
        String istorieSubIStage = userLearnStage.get(4);
        String istorieSubIIIStage = userLearnStage.get(5);
        String geografieSubIStage = userLearnStage.get(6);
        String geografieSubIIStage = userLearnStage.get(7);
        String geografieSubIIIStage = userLearnStage.get(8);
        String biologieSubIStage = userLearnStage.get(9);
        String biologieSubIIStage = userLearnStage.get(10);
        String biologieSubIIIStage = userLearnStage.get(11);
        String anatomieSubIStage = userLearnStage.get(12);
        String anatomieSubIIStage = userLearnStage.get(13);
        String anatomieSubIIIStage = userLearnStage.get(14);

        putOnSession("romanaStageSubICounterAndCorr", Ranks.getFirstElement(romanaSubIStage)+"|"+ Ranks.getSecondElement(romanaSubIStage));
        putOnSession("romanaStageSubIIICounterAndCorr", Ranks.getFirstElement(romanaSubIIIStage) + "|" + Ranks.getSecondElement(romanaSubIIIStage));
        putOnSession("istorieStageSubICounterAndCorr", Ranks.getFirstElement(istorieSubIStage)+"|"+ Ranks.getSecondElement(istorieSubIStage));
        putOnSession("istorieStageSubIIICounterAndCorr", Ranks.getFirstElement(istorieSubIIIStage)+"|"+ Ranks.getSecondElement(romanaSubIIIStage));
        putOnSession("geografieStageSubICounterAndCorr", Ranks.getFirstElement(geografieSubIStage)+"|"+ Ranks.getSecondElement(geografieSubIStage));
        putOnSession("geografieStageSubIICounterAndCorr", Ranks.getFirstElement(geografieSubIIStage)+"|"+ Ranks.getSecondElement(geografieSubIIStage));
        putOnSession("geografieStageSubIIICounterAndCorr", Ranks.getFirstElement(geografieSubIIIStage)+"|"+ Ranks.getSecondElement(geografieSubIIIStage));
        putOnSession("biologieStageSubICounterAndCorr", Ranks.getFirstElement(biologieSubIStage)+"|"+ Ranks.getSecondElement(biologieSubIStage));
        putOnSession("biologieStageSubIICounterAndCorr", Ranks.getFirstElement(biologieSubIIStage)+"|"+ Ranks.getSecondElement(biologieSubIIStage));
        putOnSession("biologieStageSubIIICounterAndCorr", Ranks.getFirstElement(biologieSubIIIStage)+"|"+ Ranks.getSecondElement(biologieSubIIIStage));
        putOnSession("anatomieStageSubICounterAndCorr", Ranks.getFirstElement(anatomieSubIStage)+"|"+ Ranks.getSecondElement(anatomieSubIStage));
        putOnSession("anatomieStageSubIICounterAndCorr", Ranks.getFirstElement(anatomieSubIIStage) + "|" + Ranks.getSecondElement(anatomieSubIIStage));
        putOnSession("anatomieStageSubIIICounterAndCorr", Ranks.getFirstElement(anatomieSubIIIStage) + "|" + Ranks.getSecondElement(anatomieSubIIIStage));
        putOnSession("userLearnStage", userLearnStage);

        if(model != null) {

        String romSubs = (String) request.getSession().getAttribute("romSubs");
        String istSubs = (String) request.getSession().getAttribute("istSubs");
        String geoSubs = (String) request.getSession().getAttribute("geoSubs");
        String bioSubs = (String) request.getSession().getAttribute("bioSubs");
        String anaSubs = (String) request.getSession().getAttribute("anaSubs");

            putOnModel("romanaStageSubIVal", Ranks.getFirstElement(romanaSubIStage) + "/" + Ranks.getFirstElement(romSubs));
            putOnModel("romanaStageSubIIIVal", Ranks.getFirstElement(romanaSubIIIStage) + "/" + Ranks.getSecondElement(romSubs));
            putOnModel("istorieStageSubIVal", Ranks.getFirstElement(istorieSubIStage) + "/" + Ranks.getFirstElement(istSubs));
            putOnModel("istorieStageSubIIIVal", Ranks.getFirstElement(istorieSubIIIStage) + "/" + Ranks.getSecondElement(istSubs));
            putOnModel("geografieStageSubIVal", Ranks.getFirstElement(geografieSubIStage) + "/" + Ranks.getFirstElement(geoSubs));
            putOnModel("geografieStageSubIIVal", Ranks.getFirstElement(geografieSubIIStage) + "/" + Ranks.getSecondElement(geoSubs));
            putOnModel("geografieStageSubIIIVal", Ranks.getFirstElement(geografieSubIIIStage) + "/" + Ranks.getThirdElement(geoSubs));
            putOnModel("biologieStageSubIVal", Ranks.getFirstElement(biologieSubIStage) + "/" + Ranks.getFirstElement(bioSubs));
            putOnModel("biologieStageSubIIVal", Ranks.getFirstElement(biologieSubIIStage) + "/" + Ranks.getSecondElement(bioSubs));
            putOnModel("biologieStageSubIIIVal", Ranks.getFirstElement(biologieSubIIIStage) + "/" + Ranks.getThirdElement(bioSubs));
            putOnModel("anatomieStageSubIVal", Ranks.getFirstElement(anatomieSubIStage) + "/" + Ranks.getFirstElement(anaSubs));
            putOnModel("anatomieStageSubIIVal", Ranks.getFirstElement(anatomieSubIIStage) + "/" + Ranks.getSecondElement(anaSubs));
            putOnModel("anatomieStageSubIIIVal", Ranks.getFirstElement(anatomieSubIIIStage) + "/" + Ranks.getThirdElement(anaSubs));

            putOnModel("romanaStageSubI", Ranks.getRankSubs(Ranks.getFirstElement(romanaSubIStage), Ranks.getFirstElement(romSubs)));
            putOnModel("romanaStageSubIII", Ranks.getRankSubs(Ranks.getFirstElement(romanaSubIIIStage), Ranks.getSecondElement(romSubs)));
            putOnModel("istorieStageSubI", Ranks.getRankSubs(Ranks.getFirstElement(istorieSubIStage), Ranks.getFirstElement(istSubs)));
            putOnModel("istorieStageSubIII", Ranks.getRankSubs(Ranks.getFirstElement(istorieSubIIIStage), Ranks.getSecondElement(istSubs)));
            putOnModel("geografieStageSubI", Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIStage), Ranks.getFirstElement(geoSubs)));
            putOnModel("geografieStageSubII", Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIIStage), Ranks.getSecondElement(geoSubs)));
            putOnModel("geografieStageSubIII", Ranks.getRankSubs(Ranks.getFirstElement(geografieSubIIIStage), Ranks.getThirdElement(geoSubs)));
            putOnModel("biologieStageSubI", Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIStage), Ranks.getFirstElement(bioSubs)));
            putOnModel("biologieStageSubII", Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIIStage), Ranks.getSecondElement(bioSubs)));
            putOnModel("biologieStageSubIII", Ranks.getRankSubs(Ranks.getFirstElement(biologieSubIIIStage), Ranks.getThirdElement(bioSubs)));
            putOnModel("anatomieStageSubI", Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIStage), Ranks.getFirstElement(anaSubs)));
            putOnModel("anatomieStageSubII", Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIIStage), Ranks.getSecondElement(anaSubs)));
            putOnModel("anatomieStageSubIII", Ranks.getRankSubs(Ranks.getFirstElement(anatomieSubIIIStage), Ranks.getThirdElement(anaSubs)));
        }
    }

    public void putUserInfoOnSession() {
        String romSubI = gameManager.getSubjectCount("romana", 1);
        String romSubIII = gameManager.getSubjectCount("romana", 3);
        String istSubI = gameManager.getSubjectCount("istorie", 1);
        String istSubIII = gameManager.getSubjectCount("istorie", 3);
        String geoSubI = gameManager.getSubjectCount("geografie", 1);
        String geoSubII = gameManager.getSubjectCount("geografie", 2);
        String geoSubIII = gameManager.getSubjectCount("geografie", 3);
        String bioSubI = gameManager.getSubjectCount("biologie", 1);
        String bioSubII = gameManager.getSubjectCount("biologie", 2);
        String bioSubIII = gameManager.getSubjectCount("biologie", 3);
        String anaSubI = gameManager.getSubjectCount("anatomie", 1);
        String anaSubII = gameManager.getSubjectCount("anatomie", 2);
        String anaSubIII = gameManager.getSubjectCount("anatomie", 3);

        putOnSession("userInfo", userManager.getUserInfo(username()));

        putOnSession("romSubs", romSubI + "|" + romSubIII);
        putOnSession("istSubs", istSubI + "|" + istSubIII);
        putOnSession("geoSubs", geoSubI + "|" + geoSubII + "|" + geoSubIII);
        putOnSession("bioSubs", bioSubI + "|" + bioSubII + "|" + bioSubIII);
        putOnSession("anaSubs", anaSubI + "|" + anaSubII+"|"+anaSubIII);
        putOnSession("username", username());
        //setting session to expiry in 30 mins
        request.getSession().setMaxInactiveInterval(30*60);
    }

    public void putOnSession(String string, Object object) {
        request.getSession().setAttribute(string, object);
    }

    public void putOnModel(String string, Object object) {
        model.addAttribute(string, object);
    }

    public String username() {
        String username;
        if(request.getUserPrincipal() == null) {
            username = (String) request.getSession().getAttribute("username");
        } else {
            username = request.getUserPrincipal().getName();
        }
        return username;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ModelMap getModel() {
        return model;
    }

    public void setModel(ModelMap model) {
        this.model = model;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
