package cn.net.liran.cn.net.liran.api;

import cn.net.liran.repository.UserRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class userAPI {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/{userName}",produces = {"application/json;charset=utf-8"})
    public String findById(@PathVariable("userName")String userName){

        return JSONArray.toJSONString(userRepository.findByUsernameContaining(userName));
    }
}
