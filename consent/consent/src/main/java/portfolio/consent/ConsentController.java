package portfolio.consent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ConsentController {

    @PostMapping("/addName")
    public String consent(@RequestParam("name") String name,@RequestParam("id") int id) {
        try (FileWriter writer = new FileWriter("portfolio.csv", true)) {
            writer.append(name);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception as per your application's requirements
        }

        return "redirect:/index"; // Redirect to a success page or another URL
    }
}