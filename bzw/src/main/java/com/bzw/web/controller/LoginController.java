package com.bzw.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bzw.entity.UserEntity;
import com.bzw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.bzw.domain.LoginForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.PrintWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, LoginForm command) {
        String username = command.getUsername();
        String password = command.getPassword();
        UserEntity userEntity = userService.getByUsername(username);

        ModelAndView mv = null;
        List<UserEntity> list=new ArrayList<UserEntity>();
        UserEntity u=new UserEntity();
        u.setUsername("张三");
        list.add(u);

        if (userEntity!=null && userEntity.getPassword().equals(password)){
            mv = new ModelAndView("/index", "command", "LOGIN SUCCESS, " + username);
        } else if (userEntity!=null && !userEntity.getPassword().equals(password)){
            mv = new ModelAndView("/index","list",list);
        } else {
            mv = new ModelAndView("/index", "command", "USERNAME ERROR!");
        }
        return mv;
    }


    //字符串转json
    private void StringToJson(HttpServletRequest req, HttpServletResponse response)throws ServletException, IOException{
        JSONObject resultJSON = new JSONObject();
        try {

            resultJSON.accumulate("name", "Violet")
                    .accumulate("occupation", "developer")
                    .accumulate("age", new Integer(22))
                    .accumulate("array", new int[] { 1, 2, 3 })
                    .accumulate("muliArray","[{'type': '你好', 'value': 'kelly@seankelly.biz'},{'type': 'home', 'pref': 1, 'value': 'kelly@seankelly.tv'}]");
            //System.out.println(resultJSON.toString(1,1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.print("ddd");
    }

}
