package com.vidnichuk.isogj;


import com.vidnichuk.isogj.api.service.user.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Ignore
public class IsogjApplicationTests {



	@Autowired
	private UserService userService;



	@Test
	public void fromVacancyToVacancyDto(){
		boolean user = userService.checkLogin("DrGrav");
		System.out.println(user);

	}




}
