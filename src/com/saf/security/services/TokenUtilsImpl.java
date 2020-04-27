package com.miraglo.security.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.miraglo.egas.dm.Nonce;
import com.miraglo.services.ApiKeyService;
import com.miraglo.services.NonceService;

@Service
public class TokenUtilsImpl implements TokenUtils{

	@Autowired
	ApiKeyService apiService;
	
	@Autowired
	NonceService nonceService;
	
	@Override
	public String getToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken(UserDetails userDetails, Long expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(String token) {
		// TODO Auto-generated method stub
		return apiService.validateKey(token)!=null;
	}

	@Override
	public UserDetails getUserFromToken(String token) {
		ArrayList<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_PENDINGAUTH"));
		UserDetails ud=new UserDetailsImpl("adm1", "adm1", authorities);
		return ud;
	}

	@Override
	public UserDetails getUserFromChallenge(String challenge) {
		Nonce nonce=nonceService.getNonce(challenge);
		if(nonce!=null){
			ArrayList<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
			
			authorities.add(new GrantedAuthorityImpl("ROLE_PENDINGAUTH"));
			UserDetails ud=new UserDetailsImpl("adm", "adm", authorities);
			return ud;
		}else{
			return null;
		}
	}

}
