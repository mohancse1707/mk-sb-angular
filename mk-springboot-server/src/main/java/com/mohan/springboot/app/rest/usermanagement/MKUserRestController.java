/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.rest.usermanagement;

import com.mohan.springboot.app.domain.usermanagement.MKUserTO;
import com.mohan.springboot.app.service.usermanagement.MKUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/mk/userManagement/user")
public class MKUserRestController {

    @Autowired
    private MKUserService mkUserService;

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<MKUserTO>> findAllUsers(){
        return new ResponseEntity<List<MKUserTO>>(mkUserService.findAllUsers(),HttpStatus.OK);
    }


}


