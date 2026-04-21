package com.exercise.products.crud_products.dto.req;

import java.math.BigDecimal;

public record ProductsPatchDTOReq(String name, BigDecimal price) {
}
