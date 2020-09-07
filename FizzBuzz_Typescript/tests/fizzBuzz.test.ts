import { FizzBuzz } from '../src/FizzBuzz';
//const fb = require('../src/fizzBuzz');
const fb = new FizzBuzz();

test('when give a number not divisible by 3 or 5, return the same number', () => { 
  expect(fb.translateNumber(1)).toBe("1");
})

test('when give a number divisible by 3, return Fizz', () => {
  expect(fb.translateNumber(3)).toBe("Fizz");
})

test('when give a number divisible by 5, return Buzz', () => {
  expect(fb.translateNumber(5)).toBe("Buzz");
})

test('when give a number divisible by 3 and 5, return FizzBuzz', () => {
  expect(fb.translateNumber(15)).toBe("FizzBuzz");
})

test('given a number generates a list of numbera from 1 to it with the FizzBuzz rules', () => {
  expect(fb.generate(20)).toBe("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz");
})
