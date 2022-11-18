package com.example.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Choice;
import com.example.domain.Question;
import com.example.service.ChoiceService;
import com.example.service.QuestionService;

@Controller
@RequestMapping("/")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@Autowired
	ChoiceService choiceService;
	
	@RequestMapping("/")
	public String welcome() {
		return "hello";
	}
	
	@RequestMapping(value= "/user/quiz", method = RequestMethod.GET)
	public String findAllQuestion(Model model, @RequestParam(defaultValue = "1") int pageNum) {

		Page<Question> page = questionService.findAll(pageNum);
		List<Question> questions = page.getContent();
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("questions", questions);
		Map<Question, List<Choice>> hm = new HashMap<>();
		for (Question q : questions) {
			List<Choice> choiceList = choiceService.findByQuestionId(q.getId());
			Collections.shuffle(choiceList);
			hm.put(q, choiceList);
		}
		model.addAttribute("questions", hm);
		return "quiz";
	}

	@RequestMapping(value="/user/quiz", method = RequestMethod.POST)
	public String showResult(HttpServletRequest request, Model model) {
		Map<String, String[]> result = new HashMap<>();
		Map<String, String[]> map = new HashMap<>();
		map = request.getParameterMap();
		int countCorrect = 0;
		for (Entry<String, String[]> entry : map.entrySet()) {
			Question q = questionService.findById(Long.parseLong(entry.getKey()));
			Choice c = choiceService.findById(Long.parseLong(entry.getValue()[0]));
			String[] strArr = new String[2];
			strArr[0] = c.getChoice();
			strArr[1] = choiceService.findCorrectChoice(c.getQuestion().getId()).getChoice();
			result.put(q.getTitle(), strArr);
			if (c.isCorrect()) {
				countCorrect++;
			}
		}
		model.addAttribute("result", result);
		model.addAttribute("countCorrect", countCorrect);
		model.addAttribute("numberOfQuestions", map.size());
		return "result";
	}

	@RequestMapping(value= "/admin/add-quiz", method = RequestMethod.GET)
	public String preAddQuiz(Model model) {
		System.out.println("GET - /admin/add-quiz");
		Question q = new Question();
		model.addAttribute("question", q);
		return "add-quiz";
	}

	@RequestMapping(value= "/admin/add-quiz", method = RequestMethod.POST)
	public String postAddQuiz(Model model, HttpServletRequest request, @ModelAttribute(name = "question") Question q) {
		Enumeration<String> paramNames = request.getParameterNames();
		Set<Choice> set = new HashSet<>();
		int index = 0;
		while(paramNames.hasMoreElements()) {
			String s = paramNames.nextElement();
			System.out.println(s);
			if (index == 0) {
				index++;
				continue;
			}
			Choice c = new Choice();
			c.setChoice(request.getParameter(s));
			if (index == 1) {
				c.setCorrect(true);
				index++;
			} else {
				c.setCorrect(false);
			}
			c.setQuestion(q);
			set.add(c);
			System.out.println(index);
		}
		q.setChoice(set);
		questionService.save(q);
		for (Choice c : set) {
			c.setQuestion(q);
		}
		return "redirect:add-quiz";
	}

	@RequestMapping(value="/admin/manage-questions")
	public String questionsList(Model model) {
		List<Question> questions = questionService.findAll();
		model.addAttribute("questions", questions);
		return "manage-questions";
	}
	
	@RequestMapping(value="/admin/update-question", method = RequestMethod.GET)
	public String preUpdateQuiz(Model model, @RequestParam("id") int id) {
		Question q = questionService.findById(id);
		model.addAttribute("question", q);
		List<Choice> choiceList = choiceService.findByQuestionId(id);
		System.out.println(choiceList);
		model.addAttribute("choiceList", choiceList);
		return "update-question";
	}
	
	@RequestMapping(value="/admin/update-question", method = RequestMethod.POST)
	public String postUpdateQuiz(HttpServletRequest request) {
		System.out.println(request.getParameterNames().toString());
		long id = Integer.parseInt(request.getParameter("id"));
		Question q = questionService.findById(id);
		q.setTitle(request.getParameter("title"));
		
		int index = 0;
		String[] choiceArr = request.getParameterValues("choice");
		Set<Choice> choices = q.getChoice();
		for (Choice c : choices) {
			c.setChoice(choiceArr[index]);
			index++;
		}
		questionService.save(q);
		return "redirect:/admin/manage-questions";
	}
	
	@RequestMapping("/admin/delete-question")
	public String deleteQuestion(@RequestParam("id") int id) {
		questionService.delete(id);
		return "redirect:/admin/manage-questions";
	}
	
}
