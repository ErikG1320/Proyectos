package idat.edu.pe.proyecto9.product;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
        public List<Product> getProducts() {
        return List.of(
			new Product(
                1L,
                "Laptop",
                1000,
                LocalDate.of(2021, Month.JANUARY, 1),
                9
			)
        );
    }
}
