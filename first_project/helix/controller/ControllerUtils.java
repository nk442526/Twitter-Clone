package first_project.helix.controller;

import first_project.helix.Tables;
import first_project.helix.database.GenericDB;
import first_project.helix.entity.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class ControllerUtils {

    public static final String TOKEN_COOKIE = "t";

    public static Member getCurrentMember(HttpServletRequest request) {
        Member member = new GenericDB<Member>().getRow(first_project.helix.tables.Member.MEMBER, Member.class, first_project.helix.tables.Member.MEMBER.ID.eq(ControllerUtils.getUserId(request)));
        if (member != null) {
            member.password = null;
        }
        return member;
    }


    public static Long getUserId(HttpServletRequest httpServletRequest) {
        Long id = (Long) httpServletRequest.getSession().getAttribute("I");
        if (id == null) {
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(TOKEN_COOKIE)) {
                        Member member = new GenericDB<Member>().getRow(Tables.MEMBER, Member.class, first_project.helix.tables.Member.MEMBER.TOKEN.eq(cookie.getValue()));
                        if (member != null && member.token != null) { //.&& author.token_expire_time != null && author.token_expire_time > new Date().getTime()) {
                            setUserSession(httpServletRequest, member);
                            return member.id;
                        }
                    }
                }
            }
        }
        return id;
    }

    public static Boolean isUserAdmin(HttpServletRequest httpServletRequest) {
        Boolean temp = (Boolean) httpServletRequest.getSession().getAttribute("A");

        if (temp != null && temp) return true;

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(TOKEN_COOKIE)) {
                    Member member = new GenericDB<Member>().getRow(Tables.MEMBER, Member.class, first_project.helix.tables.Member.MEMBER.TOKEN.eq(cookie.getValue()).and(first_project.helix.tables.Member.MEMBER.ROLE.eq("cc-admin")));
                    if (member != null && member.token != null) { //.&& author.token_expire_time != null && author.token_expire_time > new Date().getTime()) {
                        setUserSession(httpServletRequest, member);
                        return true;
                    }
                }
            }
        }
        return null;
    }

    public static Boolean isUsermine(HttpServletRequest httpServletRequest) {
        Boolean temp = (Boolean) httpServletRequest.getSession().getAttribute("CM");

        if (temp != null && temp) return true;

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(TOKEN_COOKIE)) {
                    Member member = new GenericDB<Member>().getRow(Tables.MEMBER, Member.class, first_project.helix.tables.Member.MEMBER.TOKEN.eq(cookie.getValue()).and(first_project.helix.tables.Member.MEMBER.ROLE.eq("cm")));
                    if (member != null && member.token != null) { //.&& author.token_expire_time != null && author.token_expire_time > new Date().getTime()) {
                        setUserSession(httpServletRequest, member);
                        return true;
                    }
                }
            }
        }
        return null;
    }

    public static void setUserSession(HttpServletRequest httpServletRequest, Member team) {
        httpServletRequest.getSession().setAttribute("I", team.id);
//session variable is nothing but the key value pair stored on the server.so that i get to
// know that this is my user
        if ("cc-admin".equals(team.role)) {
            httpServletRequest.getSession().setAttribute("A", true);
        }

        if ("neha".equals(team.role)) {
            httpServletRequest.getSession().setAttribute("CM", true);
        }

        if ("cm".equals(team.role)) {
            httpServletRequest.getSession().setAttribute("CM", true);
        }
    }
}
