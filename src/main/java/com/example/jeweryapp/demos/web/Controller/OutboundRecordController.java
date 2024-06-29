package com.example.jeweryapp.demos.web.Controller;


import com.example.jeweryapp.demos.web.Entity.Product;
import com.example.jeweryapp.demos.web.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/outbound")
public class OutboundRecordController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String createOutboundRecord(@RequestParam Long productId,
                                       @RequestParam String destination,
                                       Model model) {
        productService.addOutboundRecord(productId, destination);
        return "redirect:/api/outbound/success";
    }

    @GetMapping("/barcode")
    public String getProductByBarcode(@RequestParam(value = "barcode", required = false) String barcode, Model model) {
        if (barcode != null) {
            try {
                Product product = productService.getProductByBarcode(barcode);
                model.addAttribute("product", product);
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return "outbound";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}
