package portfolio.consent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ConsentController {
    @PostMapping("/grades")
    public String grades(@RequestParam("id") int id,@RequestParam("grade1") int grade1,@RequestParam("grade2") int grade2) throws IOException {
        String filePath = "portfolio.csv";
        FileWriter writer = new FileWriter(filePath, true);
        String var = id + "," + grade1 + "," + grade2;
        writer.append(var);
        writer.append("\n");
        writer.close();
        return "redirect:/success.html"; // Redirect to a success page or another URL
    }

    @PostMapping("/login")
    public String login(@RequestParam("user") String user,@RequestParam("password") String password, RedirectAttributes redirectAttributes) throws IOException {
        if((user.equals("admin")) && (password.equals("incorrect"))){
            return "redirect:/grades.html"; // Redirect to a success page or another URL
        }
        else{
            redirectAttributes.addFlashAttribute("alertMessage", "Invalid credentials! Please try again.");
            return "redirect:/index.html"; // Redirect to the login page or another URL
        }
        
    }
}