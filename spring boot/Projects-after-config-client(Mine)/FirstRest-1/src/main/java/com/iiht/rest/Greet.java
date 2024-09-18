/*
 * package com.iiht.rest;
 * 
 * import java.util.Calendar;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * //API When u r building api u r building endpoints //endpoint(Service will be
 * listening)When u r building endpoints u r building handlers //handler When u
 * r building handlers u r building specific handlers
 * 
 * @RestController
 * 
 * @RequestMapping("/rest/api.1.0") public class Greet {
 * 
 * @GetMapping
 * 
 * @RequestMapping("/abc") public String message() { return
 * "Hello my freind from other world"; }
 * 
 * @GetMapping
 * 
 * @RequestMapping("/klm") public String getTime() { return
 * Calendar.getInstance().getTime()+""; }
 * 
 * @GetMapping
 * 
 * @RequestMapping("/{gender}") public String genderMessage(@PathVariable String
 * gender) { if(gender.equals("female")) { return "welcome miss"; } else {
 * return "welcome Mr"; }
 * 
 * }
 * 
 * 
 * @GetMapping
 * 
 * @RequestMapping("/{age}") public String ageMessage(@PathVariable int age) {
 * return "Heyyy "+age;
 * 
 * }
 * 
 * @GetMapping
 * 
 * @RequestMapping("/{name}/{gender}") public String
 * genderMessage2(@PathVariable String gender,@PathVariable String name) {
 * if(gender.equals("female")) { return "welcome miss"+name; } else { return
 * "welcome Mr"+name; }
 * 
 * } }
 */