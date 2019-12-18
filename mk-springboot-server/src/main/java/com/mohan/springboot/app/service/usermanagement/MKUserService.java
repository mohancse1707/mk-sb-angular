/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.service.usermanagement;

import com.mohan.springboot.app.domain.usermanagement.MKUserTO;

import java.util.List;

public interface MKUserService {

    List<MKUserTO> findAllUsers();
}
