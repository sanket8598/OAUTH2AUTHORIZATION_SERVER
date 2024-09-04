package ai.rnt.auth2.server.service;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import ai.rnt.auth2.server.entity.EmployeeMaster;
import ai.rnt.auth2.server.entity.RoleMaster;
import ai.rnt.auth2.server.repository.EmployeeMasterRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsManager {

	@Autowired
	private EmployeeMasterRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeeMaster user = userRepository.findByUserId(email);
		if (user == null) {
			throw new UsernameNotFoundException("No User Found");
		}
		return new User(user.getUserId(), user.getPassword(), true, true, true, true, user.getEmployeeRole().stream()
				.map(RoleMaster::getRoleName).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String userId) {
		EmployeeMaster user = userRepository.findByUserId(userId);
		if (user.getUserId().equals(userId)) {
			return true;
		}
		return false;
	}
}
