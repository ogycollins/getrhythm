package com.getRhythm.getRhythm;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class MainController {
  @Autowired 
  private UserRepository userRepository;
  
  @Autowired 
  private RhythmPatternsRepository rhythmsRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
  
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
  public String processRegister(@Valid User user, BindingResult result) {
	  if (userRepository.existsUserByUsername(user.getUsername())|| userRepository.existsUserByEmail(user.getEmail())){
		  return "alreadyExists";
	  } else {
	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //BCryptPasswordEncoder so only a hash of the password is stored in database
	      String encodedPassword = passwordEncoder.encode(user.getPassword());
	      user.setPassword(encodedPassword);
	      userRepository.save(user);  
	      return "accountCreated";	  
	  }
  }

  @GetMapping("/lessons")
  String getUserProgress(Model model, HttpServletRequest request) {
	  Integer progress = getProgress(model, request);
	  model.addAttribute("progress", progress);
	  return "lessons";
  }
  
  @ResponseBody Integer getProgress(Model model, HttpServletRequest request) {
	  Principal user = request.getUserPrincipal();
	  String name = user.getName();
	  Integer progress = userRepository.findByName(name).getProgress();
	  return progress;
  }
  
  @GetMapping("/improvisation")
  String getProgress2(Model model, HttpServletRequest request) {
	  Integer progress = getProgress(model, request);
	  model.addAttribute("progress", progress);
	  return "improvisation";
  }
  
  @GetMapping("/composition")
  String getProgress3(Model model, HttpServletRequest request) {
	  Integer progress = getProgress(model, request);
	  model.addAttribute("progress", progress);
	  return "composition";
  }
  
  

 
  
}
