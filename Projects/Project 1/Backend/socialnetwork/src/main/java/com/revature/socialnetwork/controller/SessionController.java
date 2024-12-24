package com.revature.socialnetwork.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/session")
public class SessionController {

    @GetMapping("/set")
    public String setSession(@RequestParam String email, HttpSession session) {
        session.setAttribute("email", email);
        return "Session attribute 'email' set to: " + email;
    }

    @GetMapping("/get")
    public String getSessions(HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email != null) {
            return "Hello, " + email + "!";
        } else {
            return "No session found";
        }
    }

    @GetMapping("/invalidate")
    public String invalidateSession(HttpSession session) {
        session.invalidate();
        return "Session invalidated";
    }
}
