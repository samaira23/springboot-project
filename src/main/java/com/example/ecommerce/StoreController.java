package com.example.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

    private final ProductRepository productRepository;

    public StoreController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @SuppressWarnings("unchecked")
    private Map<Long, Integer> getCart(HttpSession session) {
        Map<Long, Integer> cart =
            (Map<Long, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "All") String category,
            HttpSession session,
            Model model) {

        String search = q.trim();

        List<Product> filtered = productRepository.findAll().stream()
            .filter(p -> p.getName().toLowerCase()
                .contains(search.toLowerCase()))
            .filter(p -> category.equals("All")
                || p.getCategory().equals(category))
            .collect(Collectors.toList());

        Map<Long, Integer> cart = getCart(session);
        List<CartLine> cartItems = new ArrayList<>();
        double total = 0;
        int count = 0;

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            Product product = findProduct(entry.getKey());
            if (product != null && entry.getValue() > 0) {
                cartItems.add(new CartLine(product, entry.getValue()));
                total += product.getPrice() * entry.getValue();
                count += entry.getValue();
            }
        }

        model.addAttribute("products", filtered);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartTotal", total);
        model.addAttribute("cartCount", count);
        model.addAttribute("search", search);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("categories",
            List.of("All", "Electronics", "Fashion", "Accessories", "Home"));

        return "index";
    }

    @PostMapping("/cart/add")
    public String addToCart(
            @RequestParam Long productId,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Product product = findProduct(productId);

        if (product != null) {
            Map<Long, Integer> cart = getCart(session);
            cart.merge(productId, 1, Integer::sum);
            redirectAttributes.addFlashAttribute(
                "notice", product.getName() + " added to your cart!");
        }

        return "redirect:/";
    }

    @PostMapping("/cart/update")
    public String updateCart(
            @RequestParam Long productId,
            @RequestParam int quantity,
            HttpSession session) {

        Map<Long, Integer> cart = getCart(session);

        if (findProduct(productId) != null) {
            if (quantity <= 0) {
                cart.remove(productId);
            } else {
                cart.put(productId, Math.min(quantity, 99));
            }
        }

        return "redirect:/";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(
            @RequestParam Long productId,
            HttpSession session) {

        getCart(session).remove(productId);
        return "redirect:/";
    }

    @PostMapping("/checkout")
    public String checkout(
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Map<Long, Integer> cart = getCart(session);

        if (cart.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                "notice", "Your cart is empty.");
            return "redirect:/";
        }

        double total = 0;

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            Product product = findProduct(entry.getKey());
            if (product != null) {
                total += product.getPrice() * entry.getValue();
            }
        }

        cart.clear();

        redirectAttributes.addFlashAttribute(
            "orderSuccess",
            String.format(java.util.Locale.US,
                "Demo order placed successfully! Total: ₹%.2f", total));

        return "redirect:/";
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public static class CartLine {
        private final Product product;
        private final int quantity;

        public CartLine(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getLineTotal() {
            return product.getPrice() * quantity;
        }
    }
}
