package portfolio.consent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ConsentController {

    @PostMapping("/consent")
    public String consent(@RequestParam("name") String name,@RequestParam("id") int id) throws IOException {
        String filePath = "portfolio.csv";
        FileWriter writer = new FileWriter(filePath, true);
        String var = name + "," + id;
        writer.append(var);
        writer.append("\n");
        writer.close();
        return "redirect:/success.html"; // Redirect to a success page or another URL
    }
}