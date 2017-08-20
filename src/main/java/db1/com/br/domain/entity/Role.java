package db1.com.br.domain.entity;

import com.google.common.base.Objects;
import db1.com.br.domain.model.AuthorityType;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;

    private Role(AuthorityType type) {
        this.name = type.name();
    }

    public static Role of(AuthorityType type) {
        checkNotNull(type);
        return new Role(type);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("roleName", name)
                .toString();
    }

    @Override
    public String getAuthority() {
        return name;
    }

}