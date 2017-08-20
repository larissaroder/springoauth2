package db1.com.br.domain.model;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import db1.com.br.domain.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable, UserDetails, Comparable<UserAccount> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = {
            @JoinColumn(name = "id_user_account", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "authority", nullable = false)
    })
    private Set<Authority> authorities = Sets.newHashSet();

    protected UserAccount() {
        // to serializable
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Role> getRoles() {
        return this.authorities.stream()
                .map(authority -> Role.of(authority.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public int compareTo(UserAccount o) {
        return 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return Objects.firstNonNull(password, "");
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
