package first_project.helix.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class NonAPIController extends BaseController {
    private static final Logger logger = Logger.getLogger(NonAPIController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public
    @ResponseBody
    String testControllerMethod(ModelMap model) {
        logger.info("Test call!");
        return "Test successful!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alien")
    public
    String alien(ModelMap model) {
        return "alien";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uitest")
    public
    String uiTest(ModelMap model) {
        return "uitest";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bug")
    public String getuiz(ModelMap modelMap , HttpServletRequest response ,HttpServletRequest request)
    {
        int i=10/0;
        return "hello";
    }
}
