package com.signApi.domain.entity;

import com.signApi.domain.dto.MemberDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="member")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class MemberEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String mid;
    private String mpw;
    private String name;
    private String email;
    private String mrole;

    public MemberDto toDto(){
        return MemberDto.builder().mno(this.mno).mid(this.mid).mpw(this.mpw).name(this.name).email(this.email).build();
    }
}
