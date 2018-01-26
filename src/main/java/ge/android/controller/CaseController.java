package ge.android.controller;

import ge.android.dto.CaseTypesDTO;
import ge.android.dto.CasesDTO;
import ge.android.request.AddCaseRequest;
import ge.android.services.CasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ucha
 */
@RequestMapping("/cases")
@Controller
public class CaseController {

    @Autowired
    private CasesService casesService;

    @RequestMapping("/get-cases")
    @ResponseBody
    private List<CasesDTO> getCases() throws Exception {
        return casesService.getCases();
    }

    @RequestMapping("/get-case-types")
    @ResponseBody
    private List<CaseTypesDTO> getCaseTypes() throws Exception {
        return casesService.getCaseTypes();
    }

    @RequestMapping({"/save-case"})
    @ResponseBody
    public CasesDTO saveCase(@RequestBody AddCaseRequest request) throws Exception {
        return casesService.save(request);
    }
}
