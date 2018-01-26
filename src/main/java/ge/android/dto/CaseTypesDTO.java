/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.android.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ge.android.model.CaseTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uchachaduneli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseTypesDTO {

    private int id;
    private String name;

    public static CaseTypesDTO parse(CaseTypes obj) {

        CaseTypesDTO objDTO = new CaseTypesDTO();
        objDTO.setId(obj.getId());
        objDTO.setName(obj.getName());
        return objDTO;
    }

    public static List<CaseTypesDTO> parseToList(List<CaseTypes> objList) {

        List<CaseTypesDTO> dTOs = new ArrayList<CaseTypesDTO>();
        for (CaseTypes p : objList) {
            dTOs.add(CaseTypesDTO.parse(p));
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
