package io.github.kassymbekoff.websocket.repository;

import io.github.kassymbekoff.websocket.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
