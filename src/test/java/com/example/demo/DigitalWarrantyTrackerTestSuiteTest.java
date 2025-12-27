package com.example.demo;

import org.mockito.*;
import org.testng.annotations.*;

import com.example.demo.config.JwtProperties;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.impl.*;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

@Listeners(TestResultListener.class)
public class DigitalWarrantyTrackerTestSuiteTest {

    @Mock private UserRepository userRepository;
    @Mock private ProductRepository productRepository;
    @Mock private WarrantyRepository warrantyRepository;
    @Mock private AlertScheduleRepository scheduleRepository;
    @Mock private AlertLogRepository logRepository;

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
    public void product_create_success() {
        Product p = Product.builder().modelNumber("X1").category("Electronics").build();
        when(productRepository.save(any())).thenReturn(p);
        assertEquals(productService.addProduct(p).getModelNumber(), "X1");
    }

    @Test(priority = 2)
    public void user_register_success() {
        User u = User.builder().email("a@b.com").password("pwd").build();
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(userRepository.save(any())).thenAnswer(i -> {
            User x = i.getArgument(0);
            x.setId(1L);
            return x;
        });
        assertNotNull(userService.register(u).getId());
    }

    @Test(priority = 3)
    public void warranty_register_success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User()));
        when(productRepository.findById(1L)).thenReturn(Optional.of(new Product()));
        when(warrantyRepository.existsBySerialNumber("S1")).thenReturn(false);
        when(warrantyRepository.save(any())).thenAnswer(i -> {
            Warranty w = i.getArgument(0);
            w.setId(10L);
            return w;
        });

        Warranty w = Warranty.builder()
                .serialNumber("S1")
                .purchaseDate(LocalDate.now())
                .expiryDate(LocalDate.now().plusDays(10))
                .build();

        assertEquals(warrantyService.registerWarranty(1L, 1L, w).getId().longValue(), 10L);
    }

    @Test(priority = 4)
    public void jwt_token_create_and_validate() throws Exception {
        JwtProperties props = new JwtProperties();

        Field s = JwtProperties.class.getDeclaredField("secret");
        s.setAccessible(true);
        s.set(props, "12345678901234567890123456789012");

        Field e = JwtProperties.class.getDeclaredField("expirationMs");
        e.setAccessible(true);
        e.set(props, 3600000L);

        JwtTokenProvider provider = new JwtTokenProvider(props);
        String token = provider.createToken(1L, "x@y.com", "USER");

        assertTrue(provider.validateToken(token));
    }

    @Test(priority = 5)
    public void jwt_claims_correct() throws Exception {
        JwtProperties props = new JwtProperties();

        Field s = JwtProperties.class.getDeclaredField("secret");
        s.setAccessible(true);
        s.set(props, "12345678901234567890123456789012");

        Field e = JwtProperties.class.getDeclaredField("expirationMs");
        e.setAccessible(true);
        e.set(props, 3600000L);

        JwtTokenProvider provider = new JwtTokenProvider(props);
        var claims = provider.getClaims(
                provider.createToken(11L, "c@d.com", "ADMIN")
        ).getBody();

        assertEquals(claims.get("userId", Integer.class).intValue(), 11);
        assertEquals(claims.getSubject(), "c@d.com");
    }

    @Test(priority = 6)
    public void final_integrity_check() {
        assertNotNull(userService);
        assertNotNull(productService);
        assertNotNull(warrantyService);
        assertNotNull(scheduleService);
        assertNotNull(logService);
    }
}
