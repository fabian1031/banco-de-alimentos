package com.example.Entrega_proyecto_1.DTO;

import java.math.BigDecimal;
import java.util.List;

public class DonacionCompletaRequestDTO {

    private Long donanteId;
    private List<Item> items;

    public Long getDonanteId() { return donanteId; }
    public void setDonanteId(Long donanteId) { this.donanteId = donanteId; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public static class Item {
        private Long alimentoId;
        private BigDecimal cantidad;

        public Long getAlimentoId() { return alimentoId; }
        public void setAlimentoId(Long alimentoId) { this.alimentoId = alimentoId; }

        public BigDecimal getCantidad() { return cantidad; }
        public void setCantidad(BigDecimal cantidad) { this.cantidad = cantidad; }
    }
}
