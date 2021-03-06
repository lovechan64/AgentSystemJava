package org.agent.dao.user;

import java.util.List;

import org.agent.pojo.User;

public interface UserMapper {
	public List<User> getUserList(User user);
	public User getUser(User user);
	public int addUser(User user);
	public int modifyUser(User user);
	public int deleteUser(User user);
	public int count(User user);
	public int isExitLoginUser(User user);
	public User getLoginser(User user);
}
