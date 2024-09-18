/*
 * package com.iiht.rest.extra;
 * 
 * import java.nio.charset.Charset; import java.util.ArrayList; import
 * java.util.List; import java.util.Locale;
 * 
 * import org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestHeader; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController
 * 
 * @RequestMapping("/localGreet/try.1.0") public class Greet_LocalLanguage {
 * HttpHeaders headers1=new HttpHeaders();
 * 
 * 
 * @GetMapping
 * 
 * @RequestMapping("/welcome") public ResponseEntity<String> message() {
 * ResponseEntity<String> response=new
 * ResponseEntity<>("Hello World how are u...i am fine ..hope ",HttpStatus.OK);
 * return response; }
 * Refer to link:- https://www.tabnine.com/code/java/methods/org.springframework.http.HttpHeaders/getAcceptLanguageAsLocales
 *  				https://docs.spring.io/spring-framework/docs/5.0.0.RC1_to_5.0.0.RC2/Spring%20Framework%205.0.0.RC2/org/springframework/http/HttpHeaders.html#getAcceptLanguage--
 *  				https://docs.spring.io/spring-framework/docs/5.0.0.RC1_to_5.0.0.RC2/Spring%20Framework%205.0.0.RC2/org/springframework/http/HttpHeaders.html#setAcceptLanguage-java.util.List-
 * @GetMapping
 * 
 * @RequestMapping("/greet") public ResponseEntity<List<Locale>>
 * localGreet(@RequestHeader HttpHeaders headers) {
 * 
 * Charset charset =Charset.defaultCharset(); List<Charset> list1=new
 * ArrayList<>(); list1.add(charset);
 * 
 * HttpHeaders headers22 = new HttpHeaders();
 * headers22.add(HttpHeaders.ACCEPT_LANGUAGE, value.toString()); List<Locale>
 * locales = headers22.getAcceptLanguageAsLocales();
 * 
 * List<Locale> k = headers1.getAcceptLanguageAsLocales(); return
 * ResponseEntity.status(HttpStatus.OK).headers(headers1).body(k); } }
 */