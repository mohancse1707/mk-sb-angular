/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.repository.usermanagement;

import com.mohan.springboot.app.model.token.TokenGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GenerateTokenRepository extends JpaRepository<TokenGenerator,Long> {


    @Query("select token from TokenGenerator token where 1=1")
    List<TokenGenerator> findAllToken();
}
