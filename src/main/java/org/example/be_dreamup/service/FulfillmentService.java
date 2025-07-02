package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.FulfillmentDTO;
import org.example.be_dreamup.dto.FulfillmentResponseDTO;

import java.util.List;

public interface FulfillmentService {
    FulfillmentResponseDTO create (FulfillmentDTO dto);
    FulfillmentResponseDTO update (Long id, FulfillmentDTO dto);
    List<FulfillmentResponseDTO> getAll();
    FulfillmentResponseDTO getById (Long id);
    void changeFulfillmentStatusConfirm (Long id);
    void changeFulfillmentStatusReject (Long id);
}
