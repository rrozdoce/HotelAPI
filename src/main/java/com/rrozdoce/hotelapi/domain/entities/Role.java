package com.rrozdoce.hotelapi.domain.entities;

import com.rrozdoce.hotelapi.domain.enums.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority, Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleModel roleModel;

    @Override
    public String getAuthority() {
        return null;
    }
}
