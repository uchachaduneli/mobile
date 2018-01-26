/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.android.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.android.misc.JsonDateSerializeSupport;
import ge.android.model.Users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author uchachaduneli
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UsersDTO {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int status;
    private int typeId;
    private UserTypesDTO type;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Timestamp createDate;

    public static int ACTIVE_USER = 1;
    public static int NOT_ACTIVE_USER = 2;

    public static int ADMIN = 1;
    public static int OPERATOR = 2;

    public static UsersDTO parse(Users user) {
        UsersDTO userDTO = new UsersDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setStatus(user.getStatus());
        userDTO.setTypeId(user.getType().getId());
        userDTO.setType(user.getType() != null ? UserTypesDTO.parse(user.getType()) : null);
        userDTO.setCreateDate(user.getCreateDate());
        return userDTO;
    }

    public static List<UsersDTO> parseToList(List<Users> users) {

        List<UsersDTO> dTOs = new ArrayList<UsersDTO>();
        for (Users p : users) {
            dTOs.add(UsersDTO.parse(p));
        }
        return dTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserTypesDTO getType() {
        return type;
    }

    public void setType(UserTypesDTO type) {
        this.type = type;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
