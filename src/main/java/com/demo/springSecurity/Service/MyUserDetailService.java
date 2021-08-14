package com.demo.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.springSecurity.Dao.SolarUser;
import com.demo.springSecurity.Principal.UserPrincipal;
import com.demo.springSecurity.Repo.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SolarUser user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No USER");
		}
		
		return new UserPrincipal(user);
	}

}
