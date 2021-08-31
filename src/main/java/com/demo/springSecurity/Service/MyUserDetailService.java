package com.demo.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.springSecurity.Dao.SolarUser;
import com.demo.springSecurity.Dto.UserDTO;
import com.demo.springSecurity.Principal.UserPrincipal;
import com.demo.springSecurity.Repo.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SolarUser user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No USER");
		}
		
		return new UserPrincipal(user);
	}
	
	public SolarUser saveUserDetails(UserDTO user) {
		
		SolarUser userDao = new SolarUser();
		userDao.setUsername(user.getUserName());
		userDao.setPassword(bcryptEncoder.encode(user.getUserPassword()));
		userDao.setPhone(Long.parseLong(user.getPhone()));
		userDao.setFull_name(user.getUsrFullNname());
		
		return userRepo.save(userDao);
	}

}
