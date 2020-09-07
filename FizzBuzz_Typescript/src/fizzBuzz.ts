export class FizzBuzz {
    generate(lastNumber: number): string {
        const results: string[] = []
        for (let i = 1; i <= lastNumber; i++) {
            results.push(this.translateNumber(i))
        }
        return results.join(" ")
    }

    translateNumber(givenNumber: number): string {
        if(this.isDivisibleBy3and5(givenNumber)) return "FizzBuzz";
        if(this.isDivisibleBy3(givenNumber)) return "Fizz";
        if(this.isDivisibleBy5(givenNumber)) return "Buzz";
        return givenNumber.toString();
    }
    private isDivisibleBy3(n: number): boolean {
        return n%3 == 0;
    }
    
    private isDivisibleBy5(n: number): boolean {
        return n%5 == 0;
    }

    private isDivisibleBy3and5(n: number): boolean {
        return n%15 == 0;
    }
}

