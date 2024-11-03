package com.jacoo.medidordesalario;


import org.jetbrains.annotations.NotNull;

public class UsuariosDTO {
    private String id;
    private String email;

    public UsuariosDTO(@NotNull String id, @NotNull String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
