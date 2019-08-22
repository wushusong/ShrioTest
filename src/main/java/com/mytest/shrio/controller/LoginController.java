package com.mytest.shrio.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.mytest.shrio.entity.Admin;
import com.mytest.shrio.service.ISelectService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    ISelectService selectService;

    public ISelectService getSelectService() {
        return selectService;
    }

    public void setSelectService(ISelectService selectService) {
        this.selectService = selectService;
    }

    @RequestMapping(value = "/login01")
    public ModelAndView login01(Admin admin) {
        System.out.println("001:" + admin);

        Admin admin1 = selectService.selectAdmin(admin);

        System.out.println("002" + admin1);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/login02")
    public ModelAndView login02(Admin admin) {

        ModelAndView modelAndView = new ModelAndView();

        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

        simpleAccountRealm.addAccount("admin", "b0e4311be029ff9ff14366109c6a9281");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(admin.getUname());

        String pwd = admin.getPwd();
        char[] pwdArr = new char[pwd.length()];

        for (int i = 0; i < pwd.length(); i++) {
            pwdArr[i] = pwd.charAt(i);
        }

        token.setPassword(pwdArr);

        Subject subject = SecurityUtils.getSubject();

        try {

            subject.login(token);
            modelAndView.setViewName("success");
        } catch (Exception e) {
            modelAndView.setViewName("error");
        }


        return modelAndView;

    }

    @RequestMapping(value = "/login03")
    public ModelAndView login03(Admin admin) {

        ModelAndView modelAndView = new ModelAndView();

        IniRealm iniRealm = new IniRealm("classpath:IniRealm.ini");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUname(), admin.getPwd());

        Subject subject = SecurityUtils.getSubject();

        try {

            subject.login(token);
            modelAndView.setViewName("success");
        } catch (Exception e) {
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }

    @Resource(name = "getDataSource")
    DataSource dataSource;

    @RequestMapping(value = "/login04")
    public ModelAndView login04(Admin admin) {

        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/sc");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("0123456");

        ModelAndView modelAndView = new ModelAndView();

        JdbcRealm jdbcRealm = new JdbcRealm();

        jdbcRealm.setDataSource(druidDataSource);

        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select pwd from admins where uname =?";  // and pwd = ?;

        jdbcRealm.setAuthenticationQuery(sql);

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUname(), admin.getPwd());

        try {
            subject.login(token);
            modelAndView.setViewName("success");

        }catch (Exception e){
            modelAndView.setViewName("error");
    }

        return modelAndView;

    }
}
