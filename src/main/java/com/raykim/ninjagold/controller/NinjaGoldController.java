package com.raykim.ninjagold.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NinjaGoldController {
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM d yyyy K:mm a");
	Random rand = new Random();
	ArrayList<String> message = new ArrayList<String>();
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/gold";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		message = new ArrayList<String>();
		session.invalidate();
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String gold(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		if(session.getAttribute("gold") == null) {
			message.add("Welcome to Ninja Gold!!!");
			session.setAttribute("win", true);
			session.setAttribute("gold", 0);
			session.setAttribute("messages", message);
		}
		model.addAttribute(session);
		return "gold";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		int num = rand.nextInt(6) + 10;
		message.add(0, "You worked the farm and earned " + num + " gold! " + now.format(date));
		session.setAttribute("win", true);
		session.setAttribute("gold", (int)session.getAttribute("gold") + num);
		return "redirect:/gold";
	}
	
	@RequestMapping("/cave")
	public String cave(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		int num = rand.nextInt(6) + 5;
		message.add(0, "You explored the cave and found " + num + " gold! " + now.format(date));
		session.setAttribute("win", true);
		session.setAttribute("gold", (int)session.getAttribute("gold") + num);
		return "redirect:/gold";
	}
	
	@RequestMapping("/house")
	public String house(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		int num = rand.nextInt(4) + 2;
		message.add(0, "You entered a house and found " + num + " gold! " + now.format(date));
		session.setAttribute("win", true);
		session.setAttribute("gold", (int)session.getAttribute("gold") + num);
		return "redirect:/gold";
	}
	
	@RequestMapping("/casino")
	public String casino(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		if((int)session.getAttribute("gold") < 51) {
			session.setAttribute("win", false);
			message.add(0, "You do not have enough money to play in the casino please earn more money and come back!");
			return "redirect:/gold";
		}
		int luck = rand.nextInt(102) + 1;
		int num = rand.nextInt(51);
		if(luck <= 70) {
			message.add(0, "You entered the casino and lost " + num + " gold! Better luck next time! " + now.format(date));
			session.setAttribute("win", false);
			session.setAttribute("gold", (int)session.getAttribute("gold") - num);
			return "redirect:/gold";
		}
		message.add(0, "You entered the casino and won " + num + " gold! Goodjob!! Want to try again...? " + now.format(date));
		session.setAttribute("win", true);
		session.setAttribute("gold", (int)session.getAttribute("gold") + num);
		return "redirect:/gold";
	}
}
