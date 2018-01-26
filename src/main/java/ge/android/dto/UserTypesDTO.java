/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.android.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ge.android.model.UserTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uchachaduneli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTypesDTO {

    private int id;
    private String name;

    public static UserTypesDTO parse(UserTypes obj) {

        UserTypesDTO objDTO = new UserTypesDTO();
        objDTO.setId(obj.getId());
        objDTO.setName(obj.getName());
        return objDTO;
    }

    public static List<UserTypesDTO> parseToList(List<UserTypes> objList) {

        List<UserTypesDTO> dTOs = new ArrayList<UserTypesDTO>();
        for (UserTypes p : objList) {
            dTOs.add(UserTypesDTO.parse(p));
        }
        return dTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
