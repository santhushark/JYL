package com.referrelsolution.service.impl;

import com.referrelsolution.service.*;
import com.referrelsolution.util.NullEmptyUtils;
import com.fasterxml.uuid.Logger;
import com.itextpdf.text.log.LoggerFactory;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import static com.service.impl.ServiceImpl.LOGGER;
import static com.util.StringConstantsUtils.*;


@Service//( "userService"
public class UserServiceImpl implements UserService {

private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

@Value("${google.recaptcha.endpoint}")
private String GoogleReCaptchaServiceUrl;
@Value("${google.recaptcha.secret.key}")
private String GoogleReCaptchaSecretKey;

/*
* GOOGLE RECAPTCHA V3 example 
*/

@Override
public String initiateReCaptchaVerification (String clientReCaptchaResponseToken) throws DataException{
	try{
		if (NullEmptyUtils.isNullorEmptyOrNullString(clientReCaptchaResponseToken)) {
		return FAILURE;
		}

		URL obj = new URL(GoogleReCaptchaServiceUrl);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		//add client result as post parameter
		String postParams = "secret=" + GoogleReCaptchaSecretKey + "&response=" + clientReCaptchaResponseToken;

		// send post request to google recaptcha server
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		LOGGER.info("Post parameters: " + postParams);
		LOGGER.info("Response Code: " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		LOGGER.info(response.toString());

		//Parse JSON-response
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.toString());

		Boolean success = (Boolean) json.get("success");
		Double score = (Double) json.get("score");

		LOGGER.info("success : " + success);
		LOGGER.info("score : " + score);

		//result should be successful and spam score above 0.5
		return (success && score >= 0.3)? SUCCESS : FAILURE;
		}catch (Exception e) {
			LOGGER.error(ERROR, e);
			throw new DataException(ERROR, SOMETHING_WENT_WRONG_DURING_RECAPTCHA_VERIFICATION, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
