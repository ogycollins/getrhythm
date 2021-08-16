package com.getRhythm.getRhythm;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // This means that this class is a Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RhythmPatternsRepository rhythmsRepository;

	@Autowired
	private SelfAssessmentRepository selfAssessmentRepository;
	
	@Autowired
	private ResourceRepository resourceRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping("/manageUsers")
	public String manageAccounts(Model model) {
		// This returns a JSON or XML with the users
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "manageUsers";
	}
	
	@GetMapping("/editUser")
	public String editUser(Model model, @RequestParam(value = "id", required = false) Integer id) {
		// This returns a JSON or XML with the users
		User user = userRepository.findByID(id);
		model.addAttribute("user", user);
		return "account";
	}

	@GetMapping(path = "/lessons/{id}")
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
		if (userRepository.existsUserByUsername(user.getUsername())
				|| userRepository.existsUserByEmail(user.getEmail())) {
			return "alreadyExists";
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // BCryptPasswordEncoder so only a hash
																					// of the password is stored in
																				// database
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userRepository.save(user);
			return "accountCreated";
		}
	}

	@GetMapping("/lessons")
	String getUserProgress(Model model, HttpServletRequest request) {
		Integer progress = getProgress(model, request);
		boolean[] rhythmsIncluded = { true, true, false, false, false, false, false };
		if (progress >= 2) {
			rhythmsIncluded[2] = true;
		}
		if (progress >= 3) {
			rhythmsIncluded[3] = true;
		}
		if (progress >= 4) {
			rhythmsIncluded[4] = true;
		}
		if (progress >= 5) {
			rhythmsIncluded[5] = true;
		}
		if (progress >= 6) {
			rhythmsIncluded[6] = true;
		}
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		model.addAttribute("progress", progress);
		return "lessons";
	}

	@ResponseBody
	Integer getProgress(Model model, HttpServletRequest request) {
		Principal user = request.getUserPrincipal();
		String name = user.getName();
		Integer progress = userRepository.findByName(name).getProgress();
		return progress;
	}

	@GetMapping("/improvisation")
	String getProgress2(Model model, HttpServletRequest request) {
		Integer progress = getProgress(model, request);
		boolean[] rhythmsIncluded = { true, true, false, false, false, false, false };
		if (progress >= 2) {
			rhythmsIncluded[2] = true;
		}
		if (progress >= 3) {
			rhythmsIncluded[3] = true;
		}
		if (progress >= 4) {
			rhythmsIncluded[4] = true;
		}
		if (progress >= 5) {
			rhythmsIncluded[5] = true;
		}
		if (progress >= 6) {
			rhythmsIncluded[6] = true;
		}
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		model.addAttribute("progress", progress);
		return "improvisation";
	}

	@GetMapping("/composition")
	String getProgress3(Model model, HttpServletRequest request) {
		Integer progress = getProgress(model, request);
		boolean[] rhythmsIncluded = { true, true, false, false, false, false, false };
		if (progress >= 2) {
			rhythmsIncluded[2] = true;
		}
		if (progress >= 3) {
			rhythmsIncluded[3] = true;
		}
		if (progress >= 4) {
			rhythmsIncluded[4] = true;
		}
		if (progress >= 5) {
			rhythmsIncluded[5] = true;
		}
		if (progress >= 6) {
			rhythmsIncluded[6] = true;
		}
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		model.addAttribute("progress", progress);
		return "composition";
	}

	@GetMapping("/dictation")
	String getProgress4(Model model, HttpServletRequest request) {
		Integer progress = getProgress(model, request);
		boolean[] rhythmsIncluded = { true, true, false, false, false, false, false };
		if (progress >= 2) {
			rhythmsIncluded[2] = true;
		}
		if (progress >= 3) {
			rhythmsIncluded[3] = true;
		}
		if (progress >= 4) {
			rhythmsIncluded[4] = true;
		}
		if (progress >= 5) {
			rhythmsIncluded[5] = true;
		}
		if (progress >= 6) {
			rhythmsIncluded[6] = true;
		}
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		model.addAttribute("progress", progress);	
		return "dictation";
	}

	@GetMapping("/selfAssessment")
	public String greeting(@RequestParam(value = "activity", required = false) String activity,
			@RequestParam(value = "next") String next, @RequestParam(value = "score", required = false) Integer score,
			Model model, @RequestParam(value = "saved", required = false) boolean saved) {
		ActivityDetails activityDetails = new ActivityDetails();
		activityDetails.setActivityName(activity);
		activityDetails.setNextActivity(next);
		activityDetails.setScore(score);
		model.addAttribute("activityDetails", activityDetails);
		model.addAttribute("selfAssessment", new SelfAssessment());
		if (saved) {
			String savedMessage = "Comment Saved!";
			model.addAttribute("message", savedMessage);
		}
		return "selfAssessment";
	}

	@PostMapping("/record_assessment")
	public String recordAssessment(@Valid SelfAssessment selfAssessment, @RequestParam(value = "next") String next,
			BindingResult result, HttpServletRequest request, String savedMessage) {
		Principal user = request.getUserPrincipal(); // get user
		String name = user.getName(); // get user name
		Integer userID = userRepository.findByName(name).getId(); // get user id
		selfAssessment.setUserID(userID); // add to assessment to be recorded
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // create timestamp object at current time
		selfAssessment.setTimeAndDate(timestamp); // add timestamp object to assessment object
		selfAssessmentRepository.save(selfAssessment); // persist self assessment to the database
		return "redirect:/selfAssessment?&next=" + next + "&saved=true"; // return to self assessment page and pass back
																			// the name of the next view required
	}

	@GetMapping("/updateProgress")
	public String updateProgress(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal(); // get principal user
		String name = principal.getName(); // get principal user name
		User user = userRepository.findByName(name); // get user from database
		Integer userProgress = user.getProgress(); // get user progress
		// if userProgress is less than the maximum of 6 increment it by 1 and save
		// update to the database
		if (userProgress < 6) {
			userProgress += 1;
			user.setProgress(userProgress);
			userRepository.save(user);
		}
		return "redirect:/lessons"; // return to lessons page with updated user progress level
	}

	@GetMapping("/exercises")
	public String exercises(Model model) {
		model.addAttribute("exerciseActivityDetails", new ExerciseActivityDetails());
		return "exercises";
	}

	@PostMapping("/setupExercise")
	public String setupExercise(@Valid ExerciseActivityDetails exerciseActivityDetails, Model model,
			BindingResult result) {
		boolean[] rhythmsIncluded = exerciseActivityDetails.rhythmsIncluded;
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		model.addAttribute("exerciseActivityDetails", exerciseActivityDetails);
		return "exerciseActivity"; // go to exerciseActivity page
	}
	
	@GetMapping("/resources")
	public String resources(Model model) {
		List<Resource> resources = resourceRepository.findAll();
		model.addAttribute("resources", resources);
		return "resources";
	}
	
	@GetMapping("/account")
	public String account(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal(); // get principal user
		String name = principal.getName(); // get principal user name
		User user = userRepository.findByName(name); // get user from database
		List<SelfAssessment> selfAssessments = selfAssessmentRepository.findAssesmentsByUserID(user.getId());
		model.addAttribute("selfAssessments", selfAssessments);
		model.addAttribute("user", user);
		return "account";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@Valid User user, BindingResult result) {
		String oldPassword = userRepository.findByID(user.getId()).getPassword(); // get user password from database	
		System.out.println("New Password: " + user.getPassword());
		if (user.getPassword().isEmpty()) {
			user.setPassword(oldPassword);
			System.out.println("Password not changed");
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
			String newPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(newPassword);
			System.out.println("Password changed");
		}
		userRepository.save(user); // update changes
		return "account";
	}
	
	@GetMapping({"/",  "/home"})
	public String home(Model model, HttpServletRequest request) {
		boolean[] rhythmsIncluded = { true, true, false, false, false, false, false };
		model.addAttribute("rhythmsIncluded", rhythmsIncluded);
		return "home";
	}
	

}