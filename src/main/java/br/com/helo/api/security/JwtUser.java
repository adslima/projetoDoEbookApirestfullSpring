package br.com.helo.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

	/**
	 * Atributo serialVersionUID representa
	 */
	private static final long serialVersionUID = -9100274325698400608L;

	private Long id;

	private String username;

	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser(final Long id, final String username, final String password,
			final Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;

	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Long
	 */
	public Long getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername() */
	@Override
	public String getUsername() {
		return this.username;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired() */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked() */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired() */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword() */
	@Override
	public String getPassword() {
		return this.password;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities() */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	/* (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled() */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
