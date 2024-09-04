package ai.rnt.auth2.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ai.rnt.auth2.server.entity.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, String> {

	Optional<Authorization> findByState(String state);

	Optional<Authorization> findByAuthorizationCodeValue(String authorizationCode);

	Optional<Authorization> findByAccessTokenValue(String accessToken);

	Optional<Authorization> findByRefreshTokenValue(String refreshToken);

	@Query("select a from Authorization a where a.state = :token" + " or a.authorizationCodeValue = :token"
			+ " or a.accessTokenValue = :token" + " or a.refreshTokenValue = :token")
	Optional<Authorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(
			@Param("token") String token);
}