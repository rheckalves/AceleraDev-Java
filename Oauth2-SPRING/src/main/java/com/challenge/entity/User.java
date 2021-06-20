package com.challenge.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "fullName")
    @NotNull
    @Size(max = 100)
    @Setter
    @Getter
    private String fullName;

    @Column(name = "email")
    @Email
    @Size(max = 100)
    @NotNull
    private String email;

    @Column(name = "nickname")
    @NotNull
    @Size(max = 50)
    @Setter
    @Getter
    private String nickname;

    @Column(name = "password")
    @NotNull
    @Size(max = 255)
    @Setter
    @Getter
    private String password;

    @Column(name = "createdAt")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Setter
    @Getter
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @JsonIgnore
    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
