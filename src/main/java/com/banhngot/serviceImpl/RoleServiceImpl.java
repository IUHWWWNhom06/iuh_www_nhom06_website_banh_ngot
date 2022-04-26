package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.RoleDao;
import com.banhngot.entity.Role;
import com.banhngot.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Transactional
	@Override
	public Role findRoleByName(String theRoleName) {
		// TODO Auto-generated method stub
		return roleDao.findRoleByName(theRoleName);
	}

	@Transactional
	@Override
	public List<Role> getListRole() {
		// TODO Auto-generated method stub
		return roleDao.getListRole();
	}

}
