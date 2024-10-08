package com.Outh.Autht.Service;

import com.Outh.Autht.Model.CustomUser;
import com.Outh.Autht.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String adduser(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof OAuth2AuthenticationToken oauthtoken){
            OAuth2User oAuth2User = oauthtoken.getPrincipal();
            if(oAuth2User != null){
                Map<String, Object> attributes= oAuth2User.getAttributes();
                Optional<CustomUser> optionalCustomUser = userRepository.findById((String) attributes.get("sub"));
                if(optionalCustomUser.isEmpty()){
                    CustomUser customUser=new CustomUser();
                    customUser.setId((String) attributes.get("sub"));
                    customUser.setGiven_name((String) attributes.get("given_name"));
                    customUser.setFamily_name((String) attributes.get("family_name"));
                    customUser.setName((String) attributes.get("name"));
                    customUser.setEmail((String) attributes.get("email"));
                    customUser.setPicture((String) attributes.get("picture"));

                    userRepository.save(customUser);
                }

                return "Hello," + attributes.get("given_name")+", Welcome";
            }
        }
        return "No OAuthToken found ra pumka";
    }
}
