package me.alanton.technobookingsystem.repository;

import me.alanton.technobookingsystem.entity.BookingRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRequestRepository extends JpaRepository<BookingRequestEntity, Long> {
}
