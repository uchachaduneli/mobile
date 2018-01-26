/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.android.dao;


import ge.android.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author ucha
 */
@Repository
public class UserDao extends AbstractDao<Users> {

    @PersistenceContext(unitName = "mobile")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Users> login(String username, String password, int loginType) {
        StringBuilder q = new StringBuilder();
        q.append("Select e From ").append(Users.class.getSimpleName()).
                append(" e Where e.username ='").append(username).append("'")
                .append(" and e.password ='").append(password).append("'");

        TypedQuery<Users> query = entityManager.createQuery(q.toString(), Users.class);
        return query.getResultList();
    }

}
