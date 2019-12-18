/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.repository.usermanagement;

import com.mohan.springboot.app.model.usermangement.MKUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MKUserRepository extends JpaRepository<MKUser,Long> {

}
