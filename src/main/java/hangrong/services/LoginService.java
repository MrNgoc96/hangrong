package hangrong.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import hangrong.dao.LoginDAO;
import hangrong.pojo.Account;

@Service
public class LoginService {
	@Autowired
	LoginDAO loginDAO;

	public Payload getGoogleUser(String idTokenString) {
		Payload payload = null;
		try {
			HttpTransport httpTransport = new NetHttpTransport();
			JsonFactory jsonFactory = new JacksonFactory();
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier(httpTransport, jsonFactory);
			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken != null) {
				 payload = idToken.getPayload();
			}
			return payload;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean checkLogin(String username, String password) {
		return loginDAO.checkLogin(username, password);
	}
	
	public Account getAccount(String username) {
		return loginDAO.getAccount(username);
	}
	public  boolean addAccount(Account account) {
		return loginDAO.addAccount(account);
	}

}
