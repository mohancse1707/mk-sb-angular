package com.mohan.springboot.app;

import com.mohan.springboot.app.model.token.TokenGenerator;
import com.mohan.springboot.app.service.usermanagement.GenerateTokenService;
import com.mohan.springboot.app.service.usermanagement.impl.GenerateTokenServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.properties")
public class MkSpringBootServerApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private GenerateTokenService generateTokenService;

	private long SEQ_NUMBER = 1;
	private static String DECIMAL_PADDING = "4";
	private static String STORE_NAME = "IH"; // from UI store
	private static String DATE_FORMAT = "yyyyMMdd";

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {
		@Bean
		public GenerateTokenService generateTokenService() {
			return new GenerateTokenServiceImpl();
		}
	}

	@Test
	@Rollback(false)
	public void contextLoads() {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(DATE_FORMAT);

		List<TokenGenerator> listSize = generateTokenService.findAllToken();
		System.out.println("listSize"+listSize.size());

//		TokenGenerator seq = listSize.stream()
//				.filter(tokenObj -> tokenObj.getStoreCode().equalsIgnoreCase(STORE_NAME)
//						&& tokenObj.getIssuedDateValue().equals(Long.valueOf(ft.format(dNow))))
//				.max(Comparator.comparing(TokenGenerator::getSequenceNumber))
//				.map(tokenObj -> new TokenGenerator(tokenObj))
//				.orElse(null);


		boolean seen = false;
		TokenGenerator best = null;
		Comparator<TokenGenerator> comparator = Comparator.comparing(TokenGenerator::getSequenceNumber);
		for (TokenGenerator tokenObj : listSize) {
			if (tokenObj.getStoreCode().equalsIgnoreCase(STORE_NAME)
					&& tokenObj.getIssuedDateValue().equals(Long.valueOf(ft.format(dNow)))) {
				if (!seen || comparator.compare(tokenObj, best) > 0) {
					seen = true;
					best = tokenObj;
				}
			}
		}

		TokenGenerator seq = best != null ? new TokenGenerator(best) : null;

		if(null == seq){
			//TODO save / create new token with fresh date and store;
			StringBuilder tokenNumber = getTokenBuilder(dNow, ft);
			saveTokenGenerator(dNow, ft, tokenNumber);
		} else {
			//TODO take the existing token object seq number and do increment + 1 -> save as new token
			SEQ_NUMBER = seq.getSequenceNumber()+1l;
			StringBuilder tokenNumber = getTokenBuilder(dNow, ft);
			saveTokenGenerator(dNow, ft, tokenNumber);
		}

		List<TokenGenerator> listSize1 = generateTokenService.findAllToken();
		System.out.println("listSize "+listSize1.size());
	}

	private StringBuilder getTokenBuilder(Date dNow, SimpleDateFormat ft) {
		StringBuilder tokenNumber = new StringBuilder("");
		tokenNumber.append(STORE_NAME).append("/");
		System.out.println(tokenNumber.toString());
		tokenNumber.append(ft.format(dNow)).append("/");
		tokenNumber.append(String.format("%0"+DECIMAL_PADDING+"d", SEQ_NUMBER));
		System.out.println(tokenNumber.toString());
		return tokenNumber;
	}

	private void saveTokenGenerator(Date dNow, SimpleDateFormat ft, StringBuilder tokenNumber) {
		TokenGenerator tokenGenerator = new TokenGenerator();
		tokenGenerator.setDecimalPadding(Long.valueOf(DECIMAL_PADDING));
		tokenGenerator.setIssueDate(new Date());
		tokenGenerator.setDateFormat(DATE_FORMAT);
		tokenGenerator.setSequenceNumber(SEQ_NUMBER);
		tokenGenerator.setServiceId(1l);
		tokenGenerator.setIssuedDateValue(Long.valueOf(ft.format(dNow)));
		tokenGenerator.setStoreCode(STORE_NAME);
		tokenGenerator.setTokenNumber(tokenNumber.toString());
		entityManager.persist(tokenGenerator);
	}

}
