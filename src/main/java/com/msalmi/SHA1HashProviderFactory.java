package com.msalmi;

import org.keycloak.Config.Scope;
import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.credential.hash.PasswordHashProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class SHA1HashProviderFactory implements PasswordHashProviderFactory {
	public static final String ID = "SHA-1";

	@Override
	public PasswordHashProvider create(KeycloakSession session) {
		return new SHA1HashProvider(getId());
	}

	@Override
	public void init(Scope config) {
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
	}

	@Override
	public void close() {
	}

	@Override
	public String getId() {
		return ID;
	}
}
