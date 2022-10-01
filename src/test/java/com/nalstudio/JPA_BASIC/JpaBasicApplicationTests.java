package com.nalstudio.JPA_BASIC;

import com.nalstudio.JPA_BASIC.constant.Gender;
import com.nalstudio.JPA_BASIC.domain.Member;
import com.nalstudio.JPA_BASIC.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class JpaBasicApplicationTests {
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void testRegister() {
		Member member1 = new Member();
		member1.setUserId("test1");
		member1.setUserPw("1234");
		member1.setUserName("testName");
		member1.setGender(Gender.MALE);
		member1.setJoinDate(LocalDateTime.now());

		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setUserId("test2");
		member2.setUserPw("1234");
		member2.setUserName("testName2");
		member2.setGender(Gender.FEMALE);
		member2.setJoinDate(LocalDateTime.now());

		memberRepository.save(member2);
	}

	@Test
	public void testList() {
		Iterable<Member> memberList = memberRepository.findAll();

		for(Member member : memberList) {
			System.out.println(member);
		}
	}

	@Test
	public void tstRead() {
		Optional<Member> memberOptional = memberRepository.findById(1L);

		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();

			System.out.println(member);
		}
	}

	@Test
	public void testModify() {
		Optional<Member> memberOptional = memberRepository.findById(1L);

		if(memberOptional.isPresent()) {
			Member member = memberOptional.get();
			member.setUserName("modifyName");

			memberRepository.save(member);
		}
	}

	@Test
	public void testRemove() {
		//memberRepository.deleteById(1L);
	}

	@Test
	void contextLoads() {
	}

}
