/*
 * package com.iiht.rest;
 * 
 * import java.nio.charset.Charset; import java.util.Calendar; import
 * java.util.Iterator; import java.util.List; import java.util.Map.Entry; import
 * java.util.Set;
 * 
 * import org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestHeader; import
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
 * @RequestMapping("/rest/api.2.0") public class Greet2 {
 * 
 * @GetMapping
 * 
 * @RequestMapping("/welcome") public ResponseEntity<String> message() {
 * ResponseEntity<String> response=new
 * ResponseEntity<>("Hello World how are u...i am fine ..hope ",HttpStatus.OK);
 * return response; }
 * 
 * @GetMapping
 * 
 * @RequestMapping("/time") public ResponseEntity<String> getTime() { //First
 * way is through contrutors ..but here it wasnt what we wanted so we used //the
 * second way which is the static constructors
 * 
 * return
 * ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime()+""
 * ); }
 * 
 * @GetMapping
 * 
 * @RequestMapping("/namegender/{name}/{gender}") public ResponseEntity<String>
 * genderMessage2(@RequestHeader HttpHeaders headers,@PathVariable String
 * name,@PathVariable String gender) {
 * 
 * Set<String> set1=headers.keySet(); Iterator<String> keys=set1.iterator();
 * 
 * String keyStr=null; while(keys.hasNext()) { keyStr +="\n"+keys.next(); }
 * 
 * String keyValueStr=null; Set<Entry<String, List<String>>>
 * entries=headers.entrySet();
 * 
 * Iterator iter2=entries.iterator();
 * 
 * while(iter2.hasNext()){ keyValueStr+=iter2.next()+"<br>"; }
 * 
 * //return keyValueStr; HttpHeaders headers2=new HttpHeaders();
 * headers2.setContentType(MediaType.TEXT_HTML);
 * 
 * headers2.setAcceptLanguageAsLocales("hello");
 * headers2.setAcceptCharset((List<Charset>)Charset.defaultCharset());
 * headers2.setContentLength(keyValueStr.length());
 * headers2.set("ust","GammaTrainings#6"); return
 * ResponseEntity.status(HttpStatus.OK).headers(headers2).body(keyValueStr); }
 * 
 * 
 * 
 * @GetMapping
 * 
 * @RequestMapping("/{age}") public String ageMessage(@PathVariable int age) {
 * return "Heyyy "+age;
 * 
 * }
 * 
 * 
 * 
 * PostMethod always expects to data come in forms
 * 
 * @PostMapping
 * 
 * @RequestMapping("/namegender",consumes="MediaType.APPLIATION_JSON",produces=
 * "MediaType.APPLICATION_JSON") public ResponseEntity<String>
 * genderMessage3(@RequestBody Member member){
 * member.setName(member.getName()+"helllooo"); return
 * ResponseEntity.ok(null);//Not working ..because of consumes iguess }
 * 
 * }
 */