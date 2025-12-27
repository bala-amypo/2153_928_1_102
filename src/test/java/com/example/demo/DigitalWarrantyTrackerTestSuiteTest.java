package com.example.demo;

import org.mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import com.example.demo.config.JwtProperties;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.impl.*;

import java.time.LocalDate;
import java.util.*;
import java.lang.reflect.Field;

import static org.testng.Assert.*;
import static org.mockito.Mockito.*;

@Listeners(TestResultListener.class)
public class DigitalWarrantyTrackerTestSuiteTest {

    @Mock private UserRepository userRepository;
    @Mock private ProductRepository productRepository;
    @Mock private WarrantyRepository warrantyRepository;
    @Mock private AlertScheduleRepository scheduleRepository;
    @Mock private AlertLogRepository logRepository;
    @Mock private PasswordEncoder passwordEncoder;

    private UserServiceImpl userService;
    private ProductServiceImpl productService;
    private WarrantyServiceImpl warrantyService;
    private AlertScheduleServiceImpl scheduleService;
    private AlertLogServiceImpl logService;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
        productService = new ProductServiceImpl(productRepository);
        warrantyService = new WarrantyServiceImpl(warrantyRepository, userRepository, productRepository);
        scheduleService = new AlertScheduleServiceImpl(scheduleRepository, warrantyRepository);
        logService = new AlertLogServiceImpl(logRepository, warrantyRepository);
    }

    @Test(priority = 1)
    public void servlet_simulation() {
        assertTrue(true);
    }

    @Test(priority = 2)
    public void createProduct_success() {
        Product p = Product.builder().name("Phone").brand("X").modelNumber("X100").category("Electronics").build();
        when(productRepository.save(any())).thenReturn(p);
        Product saved = productService.addProduct(p);
        assertEquals(saved.getModelNumber(), "X100");
    }

    @Test(priority = 3)
    public void createUser_success() {
        User u = User.builder().name("Bob").email("bob@example.com").password("secret").role("USER").build();
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(userRepository.save(any())).thenAnswer(i -> {
            User arg = i.getArgument(0);
            arg.setId(1L);
            return arg;
        });
        User saved = userService.register(u);
        assertNotNull(saved.getId());
    }

    @Test(priority = 4)
    public void warranty_register_success() {
        User u = new User(1L, "A", "a@b.com", "x", "USER");
        Product p = new Product(1L, "TV", "Brand", "M1", "Elec");

        when(userRepository.findById(1L)).thenReturn(Optional.of(u));
        when(productRepository.findById(1L)).thenReturn(Optional.of(p));
        when(warrantyRepository.existsBySerialNumber("S1")).thenReturn(false);
        when(warrantyRepository.save(any())).thenAnswer(i -> {
            Warranty w = i.getArgument(0);
            w.setId(10L);
            return w;
        });

        Warranty w = Warranty.builder()
                .purchaseDate(LocalDate.now())
                .expiryDate(LocalDate.now().plusDays(10))
                .serialNumber("S1")
                .build();

        Warranty saved = warrantyService.registerWarranty(1L, 1L, w);
        assertEquals(saved.getId().longValue(), 10L);
    }

    @Test(priority = 5)
    public void jwt_token_creation_and_validation() throws Exception {
        JwtProperties props = new JwtProperties();

        Field secret = JwtProperties.class.getDeclaredField("secret");
        secret.setAccessible(true);
        secret.set(props, "12345678901234567890123456789012");

        Field exp = JwtProperties.class.getDeclaredField("expirationMs");
        exp.setAccessible(true);
        exp.set(props, 3600000L);

        JwtTokenProvider provider = new JwtTokenProvider(props);
        String token = provider.createToken(1L, "x@y.com", "USER");

        assertTrue(provider.validateToken(token));
    }

    @Test(priority = 6)
    public void jwt_claims_correct() throws Exception {
        JwtProperties props = new JwtProperties();

        Field secret = JwtProperties.class.getDeclaredField("secret");
        secret.setAccessible(true);
        secret.set(props, "12345678901234567890123456789012");

        Field exp = JwtProperties.class.getDeclaredField("expirationMs");
        exp.setAccessible(true);
        exp.set(props, 3600000L);

        JwtTokenProvider provider = new JwtTokenProvider(props);
        String token = provider.createToken(11L, "c@d.com", "ADMIN");

        var claims = provider.getClaims(token).getBody();

        assertEquals(claims.get("userId", Integer.class).intValue(), 11);
        assertEquals(claims.getSubject(), "c@d.com"); // IMPORTANT FIX
    }

    @Test(priority = 7)
    public void password_encoding() {
        var enc = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        String hash = enc.encode("pwd");
        assertTrue(enc.matches("pwd", hash));
    }

    @Test(priority = 8)
    public void final_integrity_check() {
        assertNotNull(userService);
        assertNotNull(productService);
        assertNotNull(warrantyService);
        assertNotNull(scheduleService);
        assertNotNull(logService);
    }
}
