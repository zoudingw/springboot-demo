package com.zdw.springboot.study.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/20
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
    @Controller
    @RequestMapping("/user")
    public class UserController {

        /**
         * 用户查询.
         * @return
         */
        @RequestMapping("/view")
        @PreAuthorize("hasRole('admin')")
       // @RequiresPermissions("user:view")//权限管理;
        public String userInfo(){
            return "user"  ;
        }

        /**
         * 用户添加;
         * @return
         */
        @RequestMapping("/add")
       // @RolesAllowed("ADMIN")
        @PreAuthorize("hasRole('USER')")
        //  @RequiresPermissions("user:add")//权限管理;
        public String userInfoAdd(){
            return "userAdd";
        }

        /**
         * 用户删除;
         * @return
         */
        @RequestMapping("/delete")
     //   @RequiresPermissions("user:delete")//权限管理;
        public String userDel(){
            return "userDelete";
        }
}
