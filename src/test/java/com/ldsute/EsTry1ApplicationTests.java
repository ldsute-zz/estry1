package com.ldsute;

import com.ldsute.entities.AclRule;
import com.ldsute.repositories.AclRuleRepository;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.allegro.tech.embeddedelasticsearch.EmbeddedElastic;
import pl.allegro.tech.embeddedelasticsearch.IndexSettings;
import pl.allegro.tech.embeddedelasticsearch.PopularProperties;

import java.io.IOException;

import static java.lang.ClassLoader.getSystemResourceAsStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTry1ApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(EsTry1ApplicationTests.class);

	@Autowired
	private AclRuleRepository aclRuleRepository;

	private static EmbeddedElastic embeddedElastic = null;

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
		rule.setIpProtocol("tcp");

		aclRuleRepository.save(rule);
	}

	@BeforeClass
	public static void startEmbeddedElasticsearch() throws IOException, InterruptedException {
		embeddedElastic = EmbeddedElastic.builder()
				.withElasticVersion("2.2.1")
				.withSetting(PopularProperties.TRANSPORT_TCP_PORT, 9300)
//				.withSetting(PopularProperties.CLUSTER_NAME, "my_cluster")
//				.withPlugin("analysis-stempel")
//				.withIndex("cars", IndexSettings.builder()
//						.withType("car", getSystemResourceAsStream("car-mapping.json"))
//						.build())
//				.withIndex("books", IndexSettings.builder()
//						.withType(PAPER_BOOK_INDEX_TYPE, getSystemResourceAsStream("paper-book-mapping.json"))
//						.withType("audio_book", getSystemResourceAsStream("audio-book-mapping.json"))
//						.withSettings(getSystemResourceAsStream("elastic-settings.json"))
//						.build())
				.build()
				.start();
		logger.info("embedded up");
	}

	@AfterClass
	public static void stopEmbeddedElasticsearch() {
		embeddedElastic.stop();
	}
}
