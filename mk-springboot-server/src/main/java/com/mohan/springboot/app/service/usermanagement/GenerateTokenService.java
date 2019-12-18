/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.service.usermanagement;

import com.mohan.springboot.app.model.token.TokenGenerator;

import java.util.Collection;
import java.util.List;

public interface GenerateTokenService {
    List<TokenGenerator> findAllToken();

    void saveToken(TokenGenerator tokenGenerator);
}
