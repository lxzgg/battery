package com.web.battery.service.impl;

import com.web.battery.entity.Admin;
import com.web.battery.mapper.AdminMapper;
import com.web.battery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    @Transactional
    public List<Admin> getAdmin() {
        return adminMapper.getAdmin();
    }
}
