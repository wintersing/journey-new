package com.lt.journey.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://api01.idataapi.cn:8000/sight/ctrip?apikey=zq71QLetvWkIEefHcNCV7MTq5NrVGPrj8A0rLYoo3jSEv5es8OGd7c3zAQ0o592p&cityid=1&pageToken=1";

    @Test
    public void fun(){
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);
        System.out.println(result);
    }

    @Test
    public void fun1(){
        ResponseEntity<JSONObject> result = restTemplate.getForEntity(URL, JSONObject.class);
        System.out.println(result);
    }
}
