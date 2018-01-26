package ge.android.services;


import ge.android.dao.UserDao;
import ge.android.dto.UserTypesDTO;
import ge.android.dto.UsersDTO;
import ge.android.model.UserTypes;
import ge.android.model.Users;
import ge.android.request.AddUserRequest;
import ge.android.utils.MD5Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ucha
 */
@Service
public class UsersService {

    @Autowired
    private UserDao userDao;

    public List<UsersDTO> getUsers() {
        return UsersDTO.parseToList(userDao.getAll(Users.class));
    }

    public List<UserTypesDTO> getUserTypes() {
        return UserTypesDTO.parseToList(userDao.getAll(UserTypes.class));
    }

    @Transactional(rollbackFor = Throwable.class)
    public UsersDTO addUser(AddUserRequest request) throws Exception {

        Users user = request.getId() > 0 ? userDao.find(Users.class, request.getId()) : new Users();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setPassword(MD5Provider.doubleMd5(request.getPassword()));
        user.setStatus(request.getStatus());
        user.setType(userDao.find(UserTypes.class, request.getTypeId()));
        if (user.getId() > 0) {
            user = userDao.update(user);
        } else {
            user = userDao.create(user);
        }
        return UsersDTO.parse(user);
    }

    public UsersDTO login(String userName, String password, int loginType) {
        List<Users> users = userDao.login(userName, MD5Provider.doubleMd5(password), loginType);
        Users u = users != null && !users.isEmpty() ? users.get(0) : null;
        return u != null ? UsersDTO.parse(u) : null;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteUsers(int userId) {
        Users user = userDao.find(Users.class, userId);
        if (user != null) {
            userDao.delete(user);
        }
    }

}
