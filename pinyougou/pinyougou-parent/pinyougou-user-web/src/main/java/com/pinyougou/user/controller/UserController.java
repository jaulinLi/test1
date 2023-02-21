package com.pinyougou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.http.Result;
import com.pinyougou.model.User;
import com.pinyougou.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/code")
    public Result createCode(String phone) {

        try {
            userService.createCode(phone);
            return new Result(true, "验证码发送成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "验证码发送失败");
    }

    /***
     * 增加User数据
     * @param user
     * 响应数据：success
     *                  true:成功  false：失败
     *           message
     *                  响应的消息
     *
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody User user,String code) {
        try {

            //判断验证码是否相同
            Boolean bo = userService.checkCode(user.getPhone(),code);
//            if(!bo){
//                return  new Result(false,"该验证码无效！");
//            }

            //判断用户名是否重复
            int ucount = userService.getUserByUserName(user.getUsername());
            if (ucount > 0) {
                return new Result(false, "用户名重复");
            }

            //判断手机号是否注册
            int pcount = userService.getUserByPhone(user.getPhone());
            if (pcount > 0) {
                return new Result(false, "手机号已注册");
            }

            //执行增加
            int acount = userService.add(user);

            if (acount > 0) {
                //增加成功
                return new Result(true, "增加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "增加失败");
    }
}
