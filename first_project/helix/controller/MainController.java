package first_project.helix.controller;

import com.google.gson.Gson;
import first_project.helix.database.GenericDB;
import first_project.helix.entity.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

//here we r declaring class as controller
@Controller
@RequestMapping("/")
public class MainController extends BaseController {

    private static Logger logger = Logger.getLogger(MainController.class);

    /*@RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member member=ControllerUtils.getCurrentMember(request);

        if(member!=null) {
            //accessed only when he is logined
            modelMap.addAttribute("NAME", member.name);
            modelMap.addAttribute("MEMBER",member);
            return "welcome";
        }
       return "welcomelogin";
    }*/
    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member member=ControllerUtils.getCurrentMember(request);

            modelMap.addAttribute("NAME", member.name);
            return "welcome";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String signUp(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public
    @ResponseBody
    SignupResponse signUpData(@RequestBody first_project.helix.entity.Member member, HttpServletRequest request, HttpServletResponse response) {

        boolean user_created=false;
        String message=" ";
        if(GenericDB.getCount(first_project.helix.tables.Member.MEMBER,first_project.helix.tables.Member.MEMBER.EMAIL.eq(member.email))>0)
        {
            message="User already exist for this email id !";
        }else {
            member.role="cm";
            new GenericDB<Member>().addRow(first_project.helix.tables.Member.MEMBER, member);
            user_created=true;
            message="User created !";
        }
        return new SignupResponse(message,user_created);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    public String getQuiz(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String adminLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminlogin";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/time")
    public @ResponseBody String getTime(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
       TimeApi timeApi=new TimeApi(new Date(),toString(),new Date().getTime());
        return new Gson().toJson(timeApi);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/wiki")
    public @ResponseBody String getWikiResult(ModelMap modelMap, @RequestParam("country") String country, HttpServletResponse response, HttpServletRequest request) {
      WikipediaDownloader wikipediaDownloader=new WikipediaDownloader(country);
      return wikipediaDownloader .getResult();
    }

    /*

    @RequestMapping(method = RequestMethod.GET, value = "/api/wiki/html")
    public @ResponseBody String getWikiResultHtml(ModelMap modelMap, @RequestParam("country") String country, HttpServletResponse response, HttpServletRequest request) {
        WikipediaDownloader wikipediaDownloader=new WikipediaDownloader(country);
        wikipediaDownloader.getResult();
        return "wikiapi";
    }
     */


    @RequestMapping(method = RequestMethod.POST, value = "/handle")
    public
    @ResponseBody
    String handleEncrypt(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }
}