// Playground - noun: a place where people can play

import Cocoa

var str = "Hello, dear playground"

let myName: String = "Jeferson"

var number1 = 2
var number2 = 4

var result = number1 + number2

var variable1: Int
variable1 = 12

let numb: Float = 4

let concat1 = "number2: " + String(number2)
let concat2 = "number2: \(number2) okok"

var shoppingList = ["catfish", "water", "tulips"]
shoppingList[1]
shoppingList[1] = "bottle of water"
shoppingList[1]

var occupations = [
	"Malcolm": "Captain",
	"Kaylee": "Mechanic"
]

occupations["Malcolm"]

let emptyArray = String[]()

func sumVecInt(xs: Array<Int>) -> Int {
	return xs.reduce(0) { $0 + $1 }
}

var numbers = [1,2,3,4,5,6,7]

sumVecInt(numbers)

protocol Num {
	typealias N
	func zero() -> N
	func succ(n: N) -> N
	func add(x: N, y: N) -> N
	func multiply(x: N, y: N) -> N
}

