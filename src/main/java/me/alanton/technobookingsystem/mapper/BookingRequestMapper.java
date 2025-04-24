package me.alanton.technobookingsystem.mapper;

import me.alanton.technobookingsystem.dto.request.BookingRequestDTO;
import me.alanton.technobookingsystem.dto.response.BookingResponseDTO;
import me.alanton.technobookingsystem.entity.BookingRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestMapper {
    public BookingResponseDTO toBookingResponseDTO(BookingRequestEntity bookingRequestEntity) {
        return BookingResponseDTO.builder()
                .firstname(bookingRequestEntity.getFirstname())
                .lastname(bookingRequestEntity.getLastname())
                .bookingDate(bookingRequestEntity.getBookingDate())
                .bookingTime(bookingRequestEntity.getBookingTime())
                .build();
    }

    public BookingRequestEntity fromBookingRequestDTO(BookingRequestDTO bookingRequestDTO) {
        return BookingRequestEntity.builder()
                .email(bookingRequestDTO.email())
                .firstname(bookingRequestDTO.firstname())
                .lastname(bookingRequestDTO.lastname())
                .department(bookingRequestDTO.department())
                .bookingDate(bookingRequestDTO.bookingDate())
                .bookingTime(bookingRequestDTO.bookingTime())
                .guestInformation(bookingRequestDTO.guestInformation())
                .needGuide(bookingRequestDTO.needGuide())
                .status(BookingRequestEntity.RequestStatus.PENDING)
                .build();
    }
}
