package crud.repository;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
