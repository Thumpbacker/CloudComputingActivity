package com.gcu.interfaces;

import com.gcu.models.LoginModel;

public interface ValidateLoginInterface {
    boolean isAuthenticated(LoginModel login);
}
