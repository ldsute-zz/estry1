package com.ldsute;

import com.ldsute.entities.AclRule;
import com.ldsute.repositories.AclRuleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTry1ApplicationTests {

	@Autowired
	private AclRuleRepository aclRuleRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSave() throws Exception {
		AclRule rule = new AclRule();
		rule.setId("yomama");
		rule.setDestIp("1.2.3.4");
		rule.setDestPort(80);
		rule.setSrcIp("4.3.2.1");
		rule.setSrcPort(1000);

		aclRuleRepository.save(rule);
	}
}
