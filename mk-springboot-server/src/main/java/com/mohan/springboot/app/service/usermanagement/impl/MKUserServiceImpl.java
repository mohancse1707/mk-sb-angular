/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.service.usermanagement.impl;

import com.mohan.springboot.app.domain.usermanagement.MKUserTO;
import com.mohan.springboot.app.model.usermangement.MKUser;
import com.mohan.springboot.app.repository.usermanagement.MKUserRepository;
import com.mohan.springboot.app.service.usermanagement.MKUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MKUserServiceImpl implements MKUserService {

    @Autowired
    MKUserRepository mkUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MKUserTO> findAllUsers() {
        List<MKUser> userList = mkUserRepository.findAll();
        return userList.stream().map(mkUser -> modelMapper.map(mkUser, MKUserTO.class)).collect(Collectors.toList());
    }
}
