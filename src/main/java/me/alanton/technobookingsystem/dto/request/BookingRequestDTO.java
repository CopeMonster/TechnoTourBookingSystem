package me.alanton.technobookingsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record BookingRequestDTO(
        @Email @NotBlank
        String email,

        @NotBlank
        String firstname,

        @NotBlank
        String lastname,

        @NotBlank
        String department,

        @NotNull @FutureOrPresent
        LocalDate bookingDate,

        @NotNull
        LocalDateTime bookingTime,

        String guestInformation,
        boolean needGuide
) {
}
