package ge.android.services;

import ge.android.dao.CaseDao;
import ge.android.dto.CaseTypesDTO;
import ge.android.dto.CasesDTO;
import ge.android.model.CaseTypes;
import ge.android.model.Cases;
import ge.android.request.AddCaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ucha
 */
@Service
public class CasesService {

    @Autowired
    private CaseDao caseDao;

    public List<CasesDTO> getCases() {
        return CasesDTO.parseToList(caseDao.getAll(Cases.class));
    }

    public List<CaseTypesDTO> getCaseTypes() {
        return CaseTypesDTO.parseToList(caseDao.getAll(CaseTypes.class));
    }

    @Transactional(rollbackFor = Throwable.class)
    public CasesDTO save(AddCaseRequest request) throws Exception {

        Cases cases = request.getId() > 0 ? caseDao.find(Cases.class, request.getId()) : new Cases();
        cases.setAddUserId(request.getAddUserId());
        cases.setDesc(request.getDesc());
        cases.setNumber(request.getNumber());
        cases.setType(caseDao.find(CaseTypes.class, request.getTypeId()));
        if (cases.getId() > 0) {
            cases = caseDao.update(cases);
        } else {
            cases = caseDao.create(cases);
        }
        return CasesDTO.parse(cases);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void delete(int id) {
        Cases cases = caseDao.find(Cases.class, id);
        if (cases != null) {
            caseDao.delete(cases);
        }
    }

}
