package com.mytest.shrio.mapper;

import com.mytest.shrio.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ShrioMapper {

    public abstract Admin selectAdminAll(Admin admin);
}
