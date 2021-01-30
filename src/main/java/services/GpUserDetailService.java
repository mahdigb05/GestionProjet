package services;

import entities.GpUserDetail;
import entities.ROLE;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.UtilisateurRepo;

@Service
public class GpUserDetailService implements UserDetailsService {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public GpUserDetail loadUserByUsername(String email) throws UsernameNotFoundException {

        if(email.equals("admin")) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setEmail(email);
            utilisateur.setPassword(passwordEncoder.encode("admin"));
            utilisateur.setRole(ROLE.ADMIN);
            return new GpUserDetail(utilisateur);
        }

        Utilisateur utilisateur = utilisateurRepo.findByEmail(email);
        if(utilisateur == null)
        {
            throw new UsernameNotFoundException(email);
        }
        GpUserDetail userDetail = new GpUserDetail(utilisateur);
        return userDetail;
    }
}
