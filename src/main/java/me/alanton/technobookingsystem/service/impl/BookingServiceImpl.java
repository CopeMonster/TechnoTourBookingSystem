package me.alanton.technobookingsystem.service.impl;

import lombok.RequiredArgsConstructor;
import me.alanton.technobookingsystem.dto.request.BookingRequestDTO;
import me.alanton.technobookingsystem.dto.response.BookingResponseDTO;
import me.alanton.technobookingsystem.entity.BookingRequestEntity;
import me.alanton.technobookingsystem.exception.impl.BusinessException;
import me.alanton.technobookingsystem.exception.impl.BusinessExceptionReason;
import me.alanton.technobookingsystem.mapper.BookingRequestMapper;
import me.alanton.technobookingsystem.repository.BookingRequestRepository;
import me.alanton.technobookingsystem.service.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRequestRepository bookingRequestRepository;
    private final BookingRequestMapper bookingRequestMapper;

    @Override
    public BookingResponseDTO getBookingRequest(Long id) {
        BookingRequestEntity bookingRequestEntity = bookingRequestRepository.findById(id)
                .orElseThrow(() ->
                        new BusinessException(BusinessExceptionReason.BOOKING_REQUEST_NOT_FOUND));

        return bookingRequestMapper.toBookingResponseDTO(bookingRequestEntity);
    }

    @Override
    public Page<BookingResponseDTO> getAllBookingRequests(Pageable pageable) {
        Page<BookingRequestEntity> bookingRequestEntities = bookingRequestRepository.findAll(pageable);

        return bookingRequestEntities.map(bookingRequestMapper::toBookingResponseDTO);
    }

    @Override
    public BookingResponseDTO submit(BookingRequestDTO bookingRequestDTO) {
        BookingRequestEntity bookingRequestEntity =
                bookingRequestMapper.fromBookingRequestDTO(bookingRequestDTO);

        bookingRequestRepository.save(bookingRequestEntity);

        return bookingRequestMapper.toBookingResponseDTO(bookingRequestEntity);
    }

    @Override
    @Transactional
    public BookingResponseDTO updateStatus(Long id, BookingRequestEntity.RequestStatus status) {
        BookingRequestEntity bookingRequestEntity = bookingRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new BusinessException(BusinessExceptionReason.BOOKING_REQUEST_NOT_FOUND));

        bookingRequestEntity.setStatus(status);

        bookingRequestRepository.save(bookingRequestEntity);

        return bookingRequestMapper.toBookingResponseDTO(bookingRequestEntity);
    }
}
