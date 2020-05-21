package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

/**
 *@Description
 *@Param
 *@Return
 *@Author 刘汀
*/
@Data
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String code;
    private String createTime;
}