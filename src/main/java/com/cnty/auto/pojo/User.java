package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:20
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@ToString
public class User {

    private Integer user_id;
    private String user_name;
    private String user_password;

}
