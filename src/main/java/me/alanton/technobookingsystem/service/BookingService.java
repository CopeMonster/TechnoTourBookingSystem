package me.alanton.technobookingsystem.service;

import me.alanton.technobookingsystem.dto.request.BookingRequestDTO;
import me.alanton.technobookingsystem.dto.response.BookingResponseDTO;
import me.alanton.technobookingsystem.entity.BookingRequestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    BookingResponseDTO getBookingRequest(Long id);
    Page<BookingResponseDTO> getAllBookingRequests(Pageable pageable);
    BookingResponseDTO submit(BookingRequestDTO bookingRequestDTO);
    BookingResponseDTO updateStatus(Long id, BookingRequestEntity.RequestStatus status);
}
