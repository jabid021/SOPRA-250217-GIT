package quest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import quest.dao.IDAOUtilisateur;
import quest.model.Admin;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = this.daoUtilisateur.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas."));
		
		// Si l'utilisateur n'a pas été trouvé, l'exception sera jetée, et on s'arrêtera là

		// Si mot de passe en clair en base, utiliser ça :
		User.UserBuilder userBuilder = User.withUsername(username).password(passwordEncoder.encode(utilisateur.getPassword()));
		
		// Si mot de passe hashés en base, utiliser ça :
		// User.UserBuilder userBuilder = User.withUsername(username).password(utilisateur.getPassword());
		
		if(utilisateur instanceof Admin) {
			userBuilder.roles("ADMIN");
		} else if(utilisateur instanceof Formateur) {
			userBuilder.roles("FORMATEUR");
		} else if(utilisateur instanceof Stagiaire) {
			userBuilder.roles("STAGIAIRE");
		}
		
		return userBuilder.build();
	}

}
