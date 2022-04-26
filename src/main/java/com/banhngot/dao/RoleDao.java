package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.Role;

public interface RoleDao {
	public Role findRoleByName(String theRoleName);
	public List<Role> getListRole();
}
