package com.hmh.demo.controller;


import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "from zero to expert";
    }

    //通过cookie实现短暂的记忆
    @GetMapping("/fromZerotoExpert")
    public String fromZerotoExpert (HttpServletRequest request, HttpServletResponse response){

        // 获取cookie
        Cookie[] cookies = request.getCookies();
        Cookie myCookie = null;
        if (cookies != null) {
            for(Cookie cookie : cookies){
                // name和value都需要比较是否相等
                if(cookie.getName().equals("firstVisited") && cookie.getValue().equals("1")){
                    myCookie = cookie;
                    break;
                }
            }
//            Map<String, String> collect = Arrays.stream(cookies).distinct().collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
//            if(CollectionUtils.isEmpty(collect)){
//                return new String();
//            }
//            if (!StringUtils.isEmpty(collect.get("firstVisited"))){
//                myCookie = collect.get("firstVisited")
//            }
        }
        if(myCookie != null){
            return "嗨，欢迎您再次来到 from zero to expert.";
        }else {
            Cookie firstVisited = new Cookie("firstVisited", "1");
            firstVisited.setMaxAge(24 * 60 * 60);
            response.addCookie(firstVisited);
            return "嗨，欢迎您来到 from zero to expert.";
        }


    }
}
