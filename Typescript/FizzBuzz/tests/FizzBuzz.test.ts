import * as fb from '../src/FizzBuzz';
//const fizzbuzz = require('../src/fizzBuzz');
const fizzbuzz = new fb.FizzBuzz([new fb.FizzBuzzRule(), new fb.FizzRule(), new fb.BuzzRule()]);

test('when give a number not divisible by 3 or 5, return the same number', () => { 
  expect(fizzbuzz.translateNumber(1)).toBe("1");
})

test('when give a number divisible by 3, return Fizz', () => {
  expect(fizzbuzz.translateNumber(3)).toBe("Fizz");
})

test('when give a number divisible by 5, return Buzz', () => {
  expect(fizzbuzz.translateNumber(5)).toBe("Buzz");
})

test('when give a number divisible by 3 and 5, return FizzBuzz', () => {
  expect(fizzbuzz.translateNumber(15)).toBe("FizzBuzz");
})

test('given a number generates a list of numbera from 1 to it with the FizzBuzz rules', () => {
  expect(fizzbuzz.generate(20)).toBe("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz");
})

test('given a number generates a list of numbera from 1 to it with the FizzBuzz rules', () => {
  const fizzbuzzfazz = new fb.FizzBuzz([new fb.FizzBuzzRule(), new fb.FizzRule(), new fb.BuzzRule(), new fb.FazzRule()])
  expect(fizzbuzzfazz.generate(20)).toBe("1 2 Fizz 4 Buzz Fizz Fazz 8 Fizz Buzz 11 Fizz 13 Fazz FizzBuzz 16 17 Fizz 19 Buzz");
})