package com.signApi.domain.dto;

import com.signApi.domain.entity.MemberEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class MemberDto implements UserDetails {

    private int mno;
    private String mid;
    private String mpw;
    private String name;
    private String email;

    private String mrole;

    private Set<GrantedAuthority> authorities;

    public MemberEntity toEntity(){
        return MemberEntity.builder().mno(this.mno).mid(this.mid).mpw(this.mpw).name(this.name).email(this.email).build();
    }

    @Override
    public String getPassword() {
        return this.mpw;
    }

    @Override
    public String getUsername() {
        return this.mid;
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
