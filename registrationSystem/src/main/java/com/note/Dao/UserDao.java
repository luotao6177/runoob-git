package com.note.Dao;

import java.util.List;

import com.note.Model.User;


public interface UserDao {
	
	/**
     * @param username
     * @return User
     */
	User selectUserByUsername(String username);

    /**
     *
     * @param user
     * @return
     */
    int AddUser(User user);
    /**
     * 
     * @param user
     * @return
     */
    int updateUserByUsername(User user);
    /**
     * 
     * @param startRow
     * @param pageSize
     * @return
     */
    List getAllUserInfo(String startRow,String pageSize);
}
