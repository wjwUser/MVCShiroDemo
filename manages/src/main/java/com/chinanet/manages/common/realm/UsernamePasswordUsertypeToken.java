package com.chinanet.manages.common.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordUsertypeToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 1L;
    private String usertype ;

    public String getUsertype() {
        return usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    /**
     * 
     * @Title:UsernamePasswordUsertypeToken
     * @Description:测试属性----
     * @param loginName name
     * @param password	password
     * @param usertype	type:admin
     */
    public UsernamePasswordUsertypeToken(String loginName, String password, String usertype) {

        super(loginName, password);

        this.usertype = usertype;

    }

}