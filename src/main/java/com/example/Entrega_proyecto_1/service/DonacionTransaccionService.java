package com.example.Entrega_proyecto_1.service;

import com.example.Entrega_proyecto_1.DTO.DonacionCompletaRequestDTO;
import com.example.Entrega_proyecto_1.DTO.DonacionResponseDTO;
import com.example.Entrega_proyecto_1.model.Alimento;
import com.example.Entrega_proyecto_1.model.DetalleDonacion;
import com.example.Entrega_proyecto_1.model.Donacion;
import com.example.Entrega_proyecto_1.model.Donante;
import com.example.Entrega_proyecto_1.repository.AlimentoRepository;
import com.example.Entrega_proyecto_1.repository.DetalleDonacionRepository;
import com.example.Entrega_proyecto_1.repository.DonacionRepository;
import com.example.Entrega_proyecto_1.repository.DonanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class DonacionTransaccionService {

    private final DonanteRepository donanteRepository;
    private final DonacionRepository donacionRepository;
    private final AlimentoRepository alimentoRepository;
    private final DetalleDonacionRepository detalleDonacionRepository;

    @Autowired
    public DonacionTransaccionService(DonanteRepository donanteRepository,
                                      DonacionRepository donacionRepository,
                                      AlimentoRepository alimentoRepository,
                                      DetalleDonacionRepository detalleDonacionRepository) {
        this.donanteRepository = donanteRepository;
        this.donacionRepository = donacionRepository;
        this.alimentoRepository = alimentoRepository;
        this.detalleDonacionRepository = detalleDonacionRepository;
    }

    @Transactional
    public DonacionResponseDTO registrarDonacionCompleta(DonacionCompletaRequestDTO dto) {
        Donante donante = donanteRepository.findById(dto.getDonanteId())
                .orElseThrow(() -> new RuntimeException("Donante no encontrado: " + dto.getDonanteId()));

        Donacion donacion = new Donacion();
        donacion.setDonante(donante);
        donacion.setFechaDonacion(LocalDate.now());
        donacion.setTotalItems(dto.getItems().size());
        donacion = donacionRepository.save(donacion);

        for (DonacionCompletaRequestDTO.Item item : dto.getItems()) {
            Alimento alimento = alimentoRepository.findById(item.getAlimentoId())
                    .orElseThrow(() -> new RuntimeException("Alimento no encontrado: " + item.getAlimentoId()));

            DetalleDonacion detalle = new DetalleDonacion();
            detalle.setDonacion(donacion);
            detalle.setAlimento(alimento);
            detalle.setCantidad(item.getCantidad());
            detalleDonacionRepository.save(detalle);
        }

        return DonacionResponseDTO.desde(donacion);
    }
}
