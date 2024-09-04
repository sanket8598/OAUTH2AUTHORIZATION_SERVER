package ai.rnt.auth2.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.rnt.auth2.server.entity.OAuthClient;

public interface OAuthClientRepositoy extends JpaRepository<OAuthClient, String>{

	Optional<OAuthClient> findByClientId(String clientId);
}
