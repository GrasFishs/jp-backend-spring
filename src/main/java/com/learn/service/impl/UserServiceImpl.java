package com.learn.service.impl;

import com.alibaba.fastjson.JSON;
import com.learn.data.WechatResponse;
import com.learn.mapper.UserMapper;
import com.learn.model.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Value("${weapp.appid}")
    String appId;

    @Value("${weapp.appsecret}")
    String appSecret;

    private String getParams(String code) {
        return "appid=" + appId + "&secret=" + appSecret + "&grant_type=authorization_code&js_code=" + code;
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User register(User user) {
        userMapper.addUser(user);
        return user;
    }

    public WechatResponse getResponse(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + getParams(code);
        String response = restTemplate.getForObject(url, String.class);
        return JSON.parseObject(response, WechatResponse.class);
    }
}
