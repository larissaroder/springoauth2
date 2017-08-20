package db1.com.br.domain;

import db1.com.br.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserAccountRepository
        extends JpaRepository<UserAccount, Integer> {

    UserAccount findByLogin(String login);

}
