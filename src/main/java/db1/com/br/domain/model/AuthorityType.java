package db1.com.br.domain.model;

public enum AuthorityType {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;

    AuthorityType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
