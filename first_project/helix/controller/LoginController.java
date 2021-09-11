package first_project.helix.controller;

import first_project.helix.database.GenericDB;
import first_project.helix.entity.LoginResponse;
import first_project.helix.entity.Member;
import first_project.helix.entity.SignupResponse;
import org.apache.log4j.Logger;
import org.jooq.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String adminLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminlogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")//it can be of type POST
    public String userLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "userlogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String Welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "welcomelogin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/welcome")
    public
    @ResponseBody
    LoginResponse handleLogin(@RequestBody first_project.helix.entity.Member member, HttpServletRequest request, HttpServletResponse response) {
       Condition condition= first_project.helix.tables.Member.MEMBER.EMAIL.eq(member.email).and(first_project.helix.tables.Member.MEMBER.PASSWORD.eq(member.password));

       List<Member> x= (List<Member>) GenericDB.getRows(first_project.helix.tables.Member.MEMBER,Member.class, condition,1);
       if(x!=null && x.size()>0){
           //if condition is met that means both password and email matched.
           Member memberTemp=x.get(0);
           memberTemp.role="cm";
           ControllerUtils.setUserSession(request,memberTemp);
           return new LoginResponse(memberTemp.id, "Logined successfully !", true);
       }else{
           //wrong combination
           return new LoginResponse(null, "Login successfully !", false);
       }
    }

}