package portfolio.consent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class ConsentController {
    private final UserRepository userRepository;

    @Autowired
    public ConsentController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ...

    @PostMapping("/new")
    public String createUser(User user) {
        userRepository.save(user);

        // Prepare data for CSV
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{user.getName(), user.getEmail()});

        // Write data to CSV file
        try {
            CSVUtil.writeDataToCsv("portfolio.csv", csvData);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as per your application's requirements
        }

        return "redirect:/users/new";
    }
}