object ScalaExample {


class Cow {
def ^(moon: Moon) = println("Cow jumped over the moon" )
}

class Moon {
def ^:(cow: Cow) = println("This cow jumped over the moon too" )
}


val cow = new Cow                                 //> cow  : ScalaExample.Cow = ScalaExample$Cow@61e717c2
val moon = new Moon                               //> moon  : ScalaExample.Moon = ScalaExample$Moon@17f6480

cow ^ moon                                        //> Cow jumped over the moon
cow ^: moon                                       //> This cow jumped over the moon too

/*
If a method name ends with a colon ( : ), then the target of the call is
the instance that follows the operator.In this next example, ^ ( ) is a
method defined on the class Cow , while ^: ( ) is a method defined on the
class Moon :
*/

def sumOfFactors(number: Int) = {
(0 /: (1 to number)) { (sum, i) => if (number % i == 0) sum + i else sum }
}                                                 //> sumOfFactors: (number: Int)Int

def sumOfFactors1(number: Int) = {
(1 to number).foldLeft(0) {(sum, i) => if (number % i == 0) sum + i else sum }
}                                                 //> sumOfFactors1: (number: Int)Int

def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors1(candidate)
                                                  //> isPerfect: (candidate: Int)Boolean

isPerfect(6)                                      //> res0: Boolean = true

List(1,2,4).foldLeft(0){(x,y) => x+y}             //> res1: Int = 7
List(1,2,4).foldLeft(1)(_+_)                      //> res2: Int = 8

}