package com.mytest.shrio.service.impl;

import com.mytest.shrio.entity.Admin;
import com.mytest.shrio.mapper.ShrioMapper;
import com.mytest.shrio.service.ISelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectService implements ISelectService {

    @Autowired
    ShrioMapper shrioMapper;

    @Override
    public Admin selectAdmin(Admin admin) {
        Admin admin1 = shrioMapper.selectAdminAll(admin);

        return admin1;
    }
}
