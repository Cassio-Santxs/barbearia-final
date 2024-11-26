package app.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class Conversor implements Converter<Jwt, AbstractAuthenticationToken>{

//    @Override
//    public AbstractAuthenticationToken convert(Jwt jwt) {
//
//        String username = jwt.getClaimAsString("preferred_username");
//
//        Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
//        Collection<GrantedAuthority> authorities = Collections.emptyList();
//
//        if (realmAccess != null && realmAccess.containsKey("roles")) {
//            Collection<String> roles = realmAccess.get("roles");
//
//
//            authorities = roles.stream()
//                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                    .collect(Collectors.toList());
//        }
//
//
//        return new JwtAuthenticationToken(jwt, authorities, username);
//    }
	
	 @Override
	    public AbstractAuthenticationToken convert(Jwt jwt) {

	        Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
	        Collection<String> roles = realmAccess.get("roles");
	        var grants = roles
	                .stream()
	                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();

	        for( SimpleGrantedAuthority role : grants ){
	            System.out.println(role.getAuthority());
	        }

	        return new JwtAuthenticationToken(jwt, grants);
	    }

}