package com.mcnichol.cf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CfController {
    private CfService cfService;

    @Autowired
    CfController(CfService cfService) {
        this.cfService = cfService;
    }

    @RequestMapping("/organizations")
    public ResponseEntity<List<String>> organizations() {
        return new ResponseEntity<>(cfService.listOrganizations(), HttpStatus.OK);
    }
}
