package com.miraglo.security.services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miraglo.egas.dm.User;
import com.miraglo.services.UserService;

@Service("myUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	UserService userService;

	// just to emulate user data and credentials retrieval from a DB, or
	// whatsoever authentication service

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails matchingUser=null;
		logger.info("Trying to authenticate User with Name:" + username);
		User u = userService.getUserByUserName(username);
		if(u!=null){
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl("ROLE_"+u
					.getUserClass().getUserclassName());
			ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(authority);
			matchingUser = new UserDetailsImpl(u.getUsername(),
					u.getPassword(), authorities);
		}
		else{
			matchingUser=null;
		}
		if (matchingUser == null) {
			throw new UsernameNotFoundException("Wrong username or password");
		}

		return matchingUser;
	}

}