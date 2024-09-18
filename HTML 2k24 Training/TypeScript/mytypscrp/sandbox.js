//Classes
var Student = /** @class */ (function () {
    function Student() {
    }
    Student.prototype.printRecord = function () {
        console.log(this.studentId, this.firstName, this.age);
    };
    return Student;
}());
// //Pipe operator in functions
// const add1=(a:string | number | boolean,b:number,c:number)=>{
//     console.log(a,b,c);
// };
// //The above functions says that "a" can be either string number boolean
// add1(5,7,8)
// //or we can do this also 
// type myType=string | number | boolean
// const add2=(a:myType,b:number,c:number)=>{
//     console.log(a,b,c);
// }
// add2("kuidsr",56,878)
// //Objects
// let pet={"type":"Dog","name":"bruno","Breed":"German"} 
// console.log(pet.name)
// console.log(pet)
// //U can create mamny pets but with the same keys not with different keys
// //pet={"weight":25.5,"cclor":"Black","age":"5"}
// let pet2=pet
// pet2={"type":"cat","name":"Tom","Breed":"Persian"}
// console.log(pet2)
// console.log(pet)
//Objects till above only
// const add1=(a:number,b:number) =>{
// console.log(a+b);
// //To define the data type we use the colomn(:)....the last datatype before arrow says about return type of function
// //    return a+b;
// }
// const a=add1(190,23);
//  //or 
//  const b=add1
//  b(98,889)
// //default argument representation
// //i guess its best to keep the default and optional parametrs at the end ..as when we call the functions it will take the values in the same sequence we have written in the function paramters
// //It is not like python to give fu(a=09,c=77,b-19)
// const add12=(a:number,b:number=10,c?:number) =>{
//     console.log(a+b);//if c is not given then c will become undefined ...therefore we print but cant perform operations
//     console.log(c);    
// }
// const aa=add12(190);
// //? tells that the particular argument is optional..u can or u donot need to give
//Experimentation 
// let firstName=10
// firstName=100
// console.log(firstName)
// // In cmd type tsc sandbox.ts (tsc means typescript compiler ..it expects to give a type script file..it will give u a js file and THAT file is to be added in html file )
// let loc='hyderabad';
// console.log(loc);
// var date=new Date();
// console.log(date.getDate());
// let language:any;//That means it is not void and can take anyvalue ..of any data type..cn be array also
// language=true
// console.log(language)
// language =[3,4,4,5]//if we use "any" we can override also ..override with other data type
// console.log(language)
// //Program-1
// let temp=90
// if(temp==90){
//     console.log("If statement true")
// }
// else{
//     console.log("Else statement")
// }
// //Program-2
// for(let i=1;i<9;i=i+1){
//     console.log(i)
// }
// //Program-3
// let nu=56
// nu=90.7
// console.log(nu)
// //program-4
// let h=78.9
// h=9
// console.log(h)
// //Program-5
// let i=0
// while(i!=10){
//     console.log(i)
//     i++
// }
// //Program-6
// let arr=[558,449,0]
// arr.forEach(element => {
//     console.log(element)
// });
// //Program-7
// function fu(n){
//     let k=0// no matter where ever u gibe the let ..in js it will give var
//     if(n==1){
//         return 1;
//     }
//     return n*fu(n-1);
// }
// console.log(fu(5))
// //Program-8
// let fruits = ["apple","banana","orange","pichi"]
// console.log(fruits)
// console.log(fruits.length);
// fruits.push("custard")
// console.log(fruits)
// console.log(fruits.length);
// //Program-8
// let score=[
//     "rohit",240,45.76,13000,'India',true
// ]
// //Now when we hover on score varibale it will show string | number |boolean..the | is pipe symbol
// score.push("Mumbai Indians")
// console.log(score)
// //Try arrow fnc,map,callback,lambda
// //call back functions
// const isEven=(n)=>{
//     return n%2==0;
// };
// let printMsg=(someFunction,num) => {
//    const isNumEven=someFunction(num);
//    console.log(`${num} is a even number : ${isNumEven}`);
// };
// printMsg(isEven,18)
// //called as arrow function
// const square2= (n) => {
//     return n*n;
//     };
// var r=square2(9);
// alert(r);
// //reduce function
// const nums=[2,3,4,5,6,7]
// const sums=nums.reduce((accumulator,curVal)=>{
//     console.log(curVal ,accumulator)
//     return accumulator+curVal;
// })
// console.log(sums)
