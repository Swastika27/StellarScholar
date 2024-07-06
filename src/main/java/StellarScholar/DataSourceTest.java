package StellarScholar;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Bean
    public CommandLineRunner testDataSource() {
        return args -> {
            try (Connection connection = dataSource.getConnection()) {
                System.out.println("Successfully connected to the database!");
            } catch (Exception e) {
                System.err.println("Failed to connect to the database: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}

