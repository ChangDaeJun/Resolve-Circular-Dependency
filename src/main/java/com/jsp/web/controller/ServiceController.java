package com.jsp.web.controller;

import com.jsp.web.controller.Controller;
import com.jsp.web.service.ServiceMapping;

public abstract class ServiceController implements Controller {
    private final ServiceMapping serviceMapping;

    public ServiceController(ServiceMapping serviceMapping) {
        this.serviceMapping = serviceMapping;
    }
}
