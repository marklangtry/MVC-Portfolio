package portfolio.consent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
Create a Controller:

java
Copy code
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class ConsentController {
    private final UserRepository userRepository;

    @Autowired
    public ConsentController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/consent")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/consent")
    public String createUser(User user) {
        userRepository.save(user);
        return "redirect:/users/new";
    }
}