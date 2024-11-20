package com.example.moamz.controller.rest;

import com.example.moamz.service.shopping.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/shop/cart")
@RequiredArgsConstructor
public class ShopRestController {
    private final ProductService productService;

    @DeleteMapping("/shop/cart/delete/{fgCartDetailId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable("fgCartDetailId") Long fgCartDetailId) {
        try {
            productService.removeCartDetail(fgCartDetailId);
            return ResponseEntity.ok("삭제 완료");
        } catch (InternalError e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("삭제 실패: " + e.getMessage());
        }
    }

}