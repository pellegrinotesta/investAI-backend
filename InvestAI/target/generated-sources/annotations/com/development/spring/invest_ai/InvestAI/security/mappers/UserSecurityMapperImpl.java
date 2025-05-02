package com.development.spring.invest_ai.InvestAI.security.mappers;

import com.development.spring.invest_ai.InvestAI.entity.User;
import com.development.spring.invest_ai.InvestAI.security.models.UserSecurityDetails;
import com.development.spring.invest_ai.InvestAI.shared.models.Role;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T17:12:24+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserSecurityMapperImpl implements UserSecurityMapper {

    @Override
    public UserSecurityDetails mapToUserSecurityDetails(User user) {
        if ( user == null ) {
            return null;
        }

        UserSecurityDetails.UserSecurityDetailsBuilder userSecurityDetails = UserSecurityDetails.builder();

        userSecurityDetails.username( user.getEmail() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userSecurityDetails.authorities( new LinkedHashSet<Role>( set ) );
        }
        userSecurityDetails.id( user.getId() );
        userSecurityDetails.password( user.getPassword() );

        userSecurityDetails.isEnabled( true );
        userSecurityDetails.isCredentialsNonExpired( true );
        userSecurityDetails.isAccountNonLocked( true );
        userSecurityDetails.isAccountNonExpired( true );

        return userSecurityDetails.build();
    }
}
