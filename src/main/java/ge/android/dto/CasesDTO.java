/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.android.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.android.misc.JsonDateSerializeSupport;
import ge.android.model.Cases;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author uchachaduneli
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CasesDTO {
    private int id;
    private String number;
    private int addUserId;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Timestamp createDate;
    private String desc;
    private int typeId;
    private CaseTypesDTO type;

    public static CasesDTO parse(Cases cases) {
        CasesDTO caseDTO = new CasesDTO();
        caseDTO.setId(cases.getId());
        caseDTO.setNumber(cases.getNumber());
        caseDTO.setAddUserId(cases.getAddUserId());
        caseDTO.setCreateDate(cases.getCreateDate());
        caseDTO.setDesc(cases.getDesc());
        caseDTO.setTypeId(cases.getType().getId());
        caseDTO.setType(cases.getType() != null ? CaseTypesDTO.parse(cases.getType()) : null);
        caseDTO.setCreateDate(cases.getCreateDate());
        return caseDTO;
    }

    public static List<CasesDTO> parseToList(List<Cases> Cases) {

        List<CasesDTO> dTOs = new ArrayList<CasesDTO>();
        for (Cases p : Cases) {
            dTOs.add(CasesDTO.parse(p));
        }
        return dTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(int addUserId) {
        this.addUserId = addUserId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public CaseTypesDTO getType() {
        return type;
    }

    public void setType(CaseTypesDTO type) {
        this.type = type;
    }
}
