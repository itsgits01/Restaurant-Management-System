package org.example.restomanagement.RestoManagement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // Use proxy for request scope
public class RequestContext {

    private String currentUser;

    // getters and setters
    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}

