package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // get member by id
    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    // get member by name
    @GetMapping("/member/name/{name}")
    public Member getMemberByName(@PathVariable String name) {
        // Assuming you have a method to find by name in your repository
        // Replace this line with the actual method call from MemberRepository
        return memberRepository.findByName(name);
    }

    // get all members
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // add member
    @GetMapping("/member/add/{name}")
    public Member addMember(@PathVariable String name) {
        Member member = new Member();
        member.setName(name);
        return memberRepository.save(member);
    }

    // update member
    @GetMapping("/member/update/{id}/{name}")
    public Member updateMember(@PathVariable Long id, @PathVariable String name) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            member.setName(name);
            return memberRepository.save(member);
        }
        return null;
    }

    // delete member
    @GetMapping("/member/delete/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
}

