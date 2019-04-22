package com.dao.impl;
/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: UserDaoImpl
 */

import com.dao.UserDao;
import com.entity.User;
import com.framework.impl.DaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao<User> {


}
