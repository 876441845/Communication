package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:21
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@ToString
public class Role {

    private Integer role_id;
    private String role_name;
    private String role_description;

}
