/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.service.usermanagement.impl;

import com.mohan.springboot.app.model.token.TokenGenerator;
import com.mohan.springboot.app.repository.usermanagement.GenerateTokenRepository;
import com.mohan.springboot.app.service.usermanagement.GenerateTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class GenerateTokenServiceImpl implements GenerateTokenService {

    @Autowired
    GenerateTokenRepository generateTokenRepository;

    @Override
    public List<TokenGenerator> findAllToken() {
        List<TokenGenerator> tokenGenerators = null;
            tokenGenerators = generateTokenRepository.findAllToken();
        return tokenGenerators;
    }

    @Override
    public void saveToken(TokenGenerator tokenGenerator) {
        generateTokenRepository.save(tokenGenerator);
    }


}
