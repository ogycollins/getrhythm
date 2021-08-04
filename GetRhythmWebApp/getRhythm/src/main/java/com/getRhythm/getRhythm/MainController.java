package com.getRhythm.getRhythm;

import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class MainController {
  @Autowired 
  private UserRepository userRepository;
  
  @Autowired 
  private RhythmPatternsRepository rhythmsRepository;


//  @PostMapping(path="/add") // Map ONLY POST Requests
//  public @ResponseBody String addNewUser (@RequestParam String name
//      , @RequestParam String email) {
//    // @ResponseBody means the returned String is the response, not a view name
//    // @RequestParam means it is a parameter from the GET or POST request
//
//    User n = new User();
//    n.setName(name);
//    n.setEmail(email);
//    userRepository.save(n);
//    return "Saved";
//  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
  

  
//  @GetMapping(path="/rhythm2")
//  public @ResponseBody Iterable<RhythmPatterns> getRhythm2() {
//    return rhythmsRepository.findAll() ;
//  }
  
  @GetMapping(path="/lessons/{id}")
  public String getRhythmSyllables(@PathVariable("id") Integer id, Model model) {
	  RhythmPatterns rhythm = rhythmsRepository.findById(id).get();
	  String rhythmSyllables = rhythm.getRhythmSyllables();
	  model.addAttribute("rhythmSyllables", rhythmSyllables);  
	  return "lessons";
  }
  
  @GetMapping("/createAccount")
  public String showRegistrationForm(Model model) {
      model.addAttribute("user", new User());
      return "createAccount";
  }
  
  @PostMapping("/process_register")
  public String processRegister(User user) {
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //BCryptPasswordEncoder so only a hash of the password is stored in database
      String encodedPassword = passwordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      userRepository.save(user);  
      return "accountCreated";
  }
 
  
}
