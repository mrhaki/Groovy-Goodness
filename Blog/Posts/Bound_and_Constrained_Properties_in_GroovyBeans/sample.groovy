import groovy.beans.*

class Car {
   int numberOfDoors
   @Vetoable String model
   @Vetoable String brand
   boolean automatic
   @Bindable double price

   String toString() {
     "[Car details => brand: '${brand}', model: '${model}', #doors: '${numberOfDoors}', automatic: '${automatic}', price: '${price}']"
   }
}

import groovy.beans.*
import java.beans.*

def toyota = new Car(brand: 'Toyota', model: 'Verso', price: 28919, numberOfDoors: 5)
toyota.propertyChange = {
 if (it.propertyName == 'price') {
  println "The price has changed. Inform sales the new price is '${it.newValue}'." 
 }
}
toyota.vetoableChange = { PropertyChangeEvent pce ->
 if (pce.propertyName == "brand") {
  if (!(pce.newValue in ['Toyota', 'Lexus'])) {
   throw new PropertyVetoException('New value is not Toyota or Lexus', pce)
  }
 }
 if (pce.propertyName == "model") {
  if (pce.newValue ==~ /.*\d+.*/) {
   throw new PropertyVetoException('No numbers in model names allowed.', pce)
  }
 }
}

toyota.price = 30995
assert 30995 == toyota.price

toyota.brand = 'Lexus'
assert 'Lexus' == toyota.brand

try {
 toyota.brand = 'AUDI'
 assert false: 'We should not be able to set this value.'
} catch (PropertyVetoException e) {
 assert true
}

try {
 toyota.model = 'A5'
 assert false: 'We should not be able to set this value.'
} catch (PropertyVetoException e) {
 assert true
}
****