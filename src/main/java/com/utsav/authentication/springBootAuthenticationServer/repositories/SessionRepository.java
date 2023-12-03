package com.utsav.authentication.springBootAuthenticationServer.repositories;

import com.utsav.authentication.springBootAuthenticationServer.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
