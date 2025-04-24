package me.alanton.technobookingsystem.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record BookingResponseDTO(
    String firstname,
    String lastname,
    LocalDate bookingDate,
    LocalDateTime bookingTime
) {
}
