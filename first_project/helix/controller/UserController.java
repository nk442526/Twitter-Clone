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
import java.util.List;

//here we r declaring class as controller
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(method = RequestMethod.POST, value = "/create-post")
    public
    @ResponseBody
    String createTweet(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {
        Tweet tweet=new Tweet(data,null,new Date().getTime(),ControllerUtils.getUserId(request));
        new GenericDB<Tweet>().addRow(first_project.helix.tables.Tweet.TWEET,tweet);
        return "Posted successfully";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/follow-member/{member_id}")
    public
    @ResponseBody
    String followMember(@PathVariable("member_id") Long memberId, HttpServletRequest request, HttpServletResponse response) {

      Long currentUserId =ControllerUtils.getUserId(request);
      if(currentUserId!=null && memberId!=null && !currentUserId.equals(memberId)){
          Follower follower=new Follower(currentUserId,memberId);
          new GenericDB<Follower>().addRow(first_project.helix.tables.Follower.FOLLOWER,follower);
          return "Connected successfully";
      }else{
          return "Not permitted !";
      }

    }

    //follow-member
    @RequestMapping(method = RequestMethod.GET, value = "/recommendations")
    public String welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Member member=ControllerUtils.getCurrentMember(request);

        List<Member> members= (List<Member>) GenericDB.getRows(first_project.helix.tables.Member.MEMBER,Member.class,null,10,first_project.helix.tables.Member.MEMBER.ID.desc());
        modelMap.addAttribute("NAME", member.name);
        modelMap.addAttribute("RECOMMENDATIONS",members);
        return "recommendations";
    }
}