package com.web.battery.mapper;

import com.web.battery.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    List<Admin> getAdmin();

    Boolean addAdmin();
}
