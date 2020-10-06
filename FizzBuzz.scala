package com.diplomacy

object FizzBuzz {
  
  def main( args : Array[String] ) = {
    Console.println("ScizzBuzz!")
    fizzBuzz(100)
  }


  def byFactor( f : Int )( v : String)( t : (Int, String) ) =
    if( t._1 % f == 0 )
      (t._1, t._2 + v)
    else
      (t._1, t._2)

  def byFive = byFactor(5)("Fizz")  

  def byThree = byFactor(3)("Buzz")
      
  def other( t : (Int, String) ) =
    if( t._2.trim.isEmpty )
      (t._1,t._1.toString)
    else 
      (t._1,t._2)
      
  def combined = other.compose(byThree.compose(byFive))
      
  def fizzBuzz( n : Int ) =
    (1 until n)
      .map( ( _, "" ) )
      .map( combined( _ ) )
      .unzip._2
      .foreach( Console.out.println( _ ))
}
