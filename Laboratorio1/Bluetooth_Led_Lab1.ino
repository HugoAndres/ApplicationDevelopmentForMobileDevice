#include <SoftwareSerial.h>
SoftwareSerial ModBluetooth(2,3);//TX=2 &  RX=3
char android=0;
int led=13;
void setup() {
  // put your setup code here, to run once:
  pinMode(led,OUTPUT);
  ModBluetooth.begin(9600); 
  Serial.begin(9600);  
  digitalWrite(led,LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(ModBluetooth.available()){
    android=ModBluetooth.read();
    if(android=='0'){
      digitalWrite(led,LOW);
      delay(500); 
    }else if(android=='1'){
      digitalWrite(led,HIGH);
      delay(500);
    }
  }
}
