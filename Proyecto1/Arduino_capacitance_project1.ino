#include <SoftwareSerial.h>
#include <TimeLib.h>  
SoftwareSerial blue(0, 1); //TX=2 &  RX=3
char val=' ';

#define analogPin      0          
#define chargePin      13         
#define dischargePin   8
#define gnd   A2        
#define resistorValue  10000.0F  //Remember, we've used a 10K resistor to charge the capacitor
int minuto, minuto2;

unsigned long startTime;
unsigned long elapsedTime;
float microFarads;                
float nanoFarads;

    

void setup(){
  Serial.begin(9600);
  pinMode(chargePin, OUTPUT);     
  digitalWrite(chargePin, LOW);
  pinMode(gnd, OUTPUT);     
  digitalWrite(gnd, LOW); 
  setTime(19, 58, 00, 6, 11, 2014);
  blue.begin(9600);
  
}

void loop(){
  time_t t = now();
  minuto = minute(t);
  
  //Serial.println("10nf");
  if(blue.available()){
    val=blue.read();
    if(val == 'I'){
      //Serial.println("llego I");
      digitalWrite(chargePin, HIGH);  //apply 5 Volts
      startTime = micros();           //Start the counter
      while(analogRead(analogPin) < 648){   }    //While the value is lower than 648, just wait
      elapsedTime= micros() - startTime;
      microFarads = ((float)elapsedTime / resistorValue) ; //calculate the capacitance value 
      elapsedTime= micros() - startTime;
      microFarads = ((float)elapsedTime / resistorValue) ; //calculate the capacitance value
      if(microFarads > 1){
        String myString = "";
        myString.concat(microFarads);
        myString.concat("uF");
        blue.println(myString);
        Serial.println(myString);
        delay(500);    
      }else{
        String myString = "";
        nanoFarads = microFarads * 1000.0; 
        myString.concat(nanoFarads);
        myString.concat("nF");      
        blue.println(myString);
        Serial.println(myString);      
        delay(500); 
      }
      
      digitalWrite(chargePin, LOW);            
      pinMode(dischargePin, OUTPUT);            
      digitalWrite(dischargePin, LOW);     //discharging the capacitor     
      while(analogRead(analogPin) > 0){         
      }//This while waits till the capaccitor is discharged
      pinMode(dischargePin, INPUT);      //this sets the pin to high impedance 
    }else{
      blue.println("Cadena");
    }
  }

     
}
