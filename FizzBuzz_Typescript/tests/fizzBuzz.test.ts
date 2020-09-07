import { fizzBuzz } from '../src/fizzBuzz';
//const fb = require('../src/fizzBuzz');

test('when give a number not divisible by 3 or 5, return the same number', () => {
  expect(fizzBuzz(1)).toBe(1);
})

test('when give a number divisible by 3, return Fizz', () => {
  expect(fizzBuzz(3)).toBe("Fizz");
})

test('when give a number divisible by 5, return Buzz', () => {
  expect(fizzBuzz(5)).toBe("Buzz");
})

test('when give a number divisible by 3 and 5, return FizzBuzz', () => {
  expect(fizzBuzz(15)).toBe("FizzBuzz");
})