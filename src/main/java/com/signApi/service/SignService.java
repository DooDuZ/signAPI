package com.signApi.service;

import com.signApi.domain.dto.MemberDto;
import com.signApi.domain.entity.MemberEntity;
import com.signApi.domain.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SignService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;
    // @Autowired
    // PasswordEncoder pwEncoder;

    // 시큐리티 로그인 메서드
    @Override
    public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByMid(mid)
                .orElseThrow( () -> new UsernameNotFoundException("존재하지 않는 사용자 입니다.") );

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority( memberEntity.getMrole() ));

        MemberDto memberDto = memberEntity.toDto();
        memberDto.setAuthorities(authorities);

        return memberDto;
    }

    @Transactional
    public int sighUp(MemberDto memberDto){
        Optional<MemberEntity> optional = memberRepository.findByMid(memberDto.getMid());
        if(optional.isPresent()){ return 0; } // 이미 존재하는 아이디
        MemberEntity memberEntity = memberDto.toEntity();
        memberEntity.setMpw(new BCryptPasswordEncoder().encode(memberDto.getMpw()));
        memberEntity.setMrole("일반회원");
        memberRepository.save(memberEntity);
        return 1;
    }
}
