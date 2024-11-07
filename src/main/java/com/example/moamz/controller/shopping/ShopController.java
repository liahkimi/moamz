package com.example.moamz.controller.shopping;

import com.example.moamz.domain.dto.shopping.CartDTO;
import com.example.moamz.domain.dto.shopping.CartDetailDTO;
import com.example.moamz.domain.dto.shopping.ProductListMainDTO;
import com.example.moamz.service.shopping.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ProductService productService;

    @GetMapping("/list")
    public String productList(Model model){
        List<ProductListMainDTO> productList = productService.showProductList();
        model.addAttribute("productList", productList);

        return "shopping/productList";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        Long sampleUserCode = 1L;
        Long sampleCartCode = productService.findCartId(sampleUserCode);
        List<CartDTO> cartLists = productService.showCartList(sampleCartCode);

//        for(CartDTO cartDTO : cartLists){
//            cartDTO.getE
//        }

        model.addAttribute("cartLists", cartLists);

        return "shopping/cart";
    }

    @GetMapping("/payment")
    public String payment(Model model){
        return "shopping/payment";
    }

    @GetMapping("/storeList")
    public String shoplist(Model model){
        return "shopping/storeList";
    }

    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody CartDetailDTO cartDetailDTO) {
        try {
            productService.addCartDetail(cartDetailDTO); // 서비스 호출
            System.out.println("굿 cartDetailDTO = " + cartDetailDTO + "굿");
            return ResponseEntity.ok("장바구니에 추가 완료");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("배드 cartDetailDTO = " + cartDetailDTO);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("장바구니 추가 실패: " + e.getMessage());
        }
    }
}















