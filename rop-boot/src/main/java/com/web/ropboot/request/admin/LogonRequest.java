package com.web.ropboot.request.admin;

import com.rop.AbstractRopRequest;
import org.hibernate.validator.constraints.NotEmpty;

public class LogonRequest extends AbstractRopRequest {

    @NotEmpty
    private String mobile;

    @NotEmpty
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
