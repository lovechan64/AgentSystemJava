package org.agent.service.role;

import java.util.List;

import org.agent.pojo.Role;

public interface RoleService {
	public List<Role> getRoleList();
	public Role getRole(Role role);
	public int addRole(Role role);
	public int modifyRole(Role role);
	public int deleteRole(Role role);
	public List<Role> getRoleIdAndNameList();
	public int isPeatRole(Role role);
}
