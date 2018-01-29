package ge.android.controller;

import ge.android.dto.UserTypesDTO;
import ge.android.dto.UsersDTO;
import ge.android.misc.Response;
import ge.android.request.AddUserRequest;
import ge.android.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ucha
 */
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/get-users")
    @ResponseBody
    private List<UsersDTO> getUsers() throws Exception {
        return usersService.getUsers();
    }

    @RequestMapping("/get-user-types")
    @ResponseBody
    private List<UserTypesDTO> getUserTypes() throws Exception {
        return usersService.getUserTypes();
    }

    @RequestMapping({"/save-user"})
    @ResponseBody
    public UsersDTO saveUser(@RequestBody AddUserRequest request) throws Exception {
        return usersService.addUser(request);
    }

    @RequestMapping(value = {"/login"})
    @ResponseBody
    public UsersDTO saveUser(@RequestParam String username, @RequestParam String password) throws Exception {
        return usersService.login(username, password);
    }

    @RequestMapping({"/delete-user"})
    @ResponseBody
    public Response saveUser(@RequestParam Integer userId) throws Exception {
        usersService.deleteUsers(userId);
        return Response.ok();
    }
}
