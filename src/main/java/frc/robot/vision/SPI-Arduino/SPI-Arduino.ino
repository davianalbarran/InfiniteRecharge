#include <SPI.h>
const int dataReadyPin = 6;
const int chipSelectPin = 7;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

  SPI.begin();

  // initalize the  data ready and chip select pins:
  pinMode(dataReadyPin, INPUT);
  pinMode(chipSelectPin, OUTPUT);

  delay(100);
}

void loop() {
  // put your main code here, to run repeatedly:

}
