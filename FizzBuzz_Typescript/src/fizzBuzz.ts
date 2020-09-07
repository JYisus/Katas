export function fizzBuzz(givenNumber: number): number | string {
    if(isDivisibleBy3(givenNumber) && isDivisibleBy5(givenNumber)) return "FizzBuzz";
    if(isDivisibleBy3(givenNumber)) return "Fizz";
    if(isDivisibleBy5(givenNumber)) return "Buzz";
    return givenNumber;
}

function isDivisibleBy3(n: number): boolean {
    return n%3 == 0;
}

function isDivisibleBy5(n: number): boolean {
    return n%5 == 0;
}