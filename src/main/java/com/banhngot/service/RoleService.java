package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Role;

public interface RoleService {
	public Role findRoleByName(String theRoleName);
	public List<Role> getListRole();
}
