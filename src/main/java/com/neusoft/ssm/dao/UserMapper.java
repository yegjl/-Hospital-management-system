package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 登录注册找回密码页面跳转接口类
 * @author Nebula
 * @version 1.10 2019/06/26
 * */

public interface UserMapper {

	/**
	 * 登录
	 * @Param login_name 用户名
	 * @Param password 密码
	 * @return (User)
	 */
	User login(@Param("login_name") String login_name, @Param("password") String password);

	/**
	 * 注册
	 * @Param login_name 用户名
	 * @Param password 密码
	 * @Param category 用户类型
	 * @Param question 密保问题
	 * @Param answer 密保答案
	 * @return (boolean)
	 */
	boolean register(@Param("login_name") String login_name, @Param("password") String password, @Param("category") String category, @Param("question") String question, @Param("answer") String answer);

	/**
	 * 按用户名获取用户类型
	 * @Param login_name 用户名
	 * @return (String)
	 */
	String selectCategory(@Param("login_name") String login_name);

	/**
	 * 按用户id删除用户信息
	 * @Param id 用户id
	 * @return (boolean)
	 */
	boolean deleteUserById(int id);

	/**
	 * 编辑用户信息
	 * @Param user User对象
	 * @return (boolean)
	 */
	boolean updateUser(User user);

	/**
	 * 按用户名查找用户信息
	 * @Param login_name 用户名
	 * @return (User)
	 */
	User findUserById(String login_name);

	/**
	 * 按用户名验证用户是否存在
	 * @Param login_name 用户名
	 * @return (int)
	 */
	int findUserByLgName(String login_name);

	/**
	 * 获取全部用户信息列表
	 * @return (List<User>)
	 */
	List<User> selectByList();

	/**
	 * 按用户id查找用户信息
	 * @Param id 用户id
	 * @return (User)
	 */
	User findNameById(@Param("id") Long id);
	int insertSelective(User record);

	int deleteUserByName(String name);

	List<User> getSearchUser(String login_name, String real_name,String id);
	List<User> findByUserType(String id);
}
