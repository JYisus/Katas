export class FizzBuzz {
    constructor(private rules: TranslateRule[]) {}
    addRule(newRule: TranslateRule) {
        this.rules.push(newRule);
    }
    generate(lastNumber: number): string {
        const results: string[] = []
        for (let i = 1; i <= lastNumber; i++) {
            results.push(this.translateNumber(i))
        }
        return results.join(" ")
    }

    translateNumber(givenNumber: number): string {
        for (const rule of this.rules) {
            if (rule.match(givenNumber)) {
                return rule.translateNumber(givenNumber);
            }
        }
        return givenNumber.toString();
    }
}

interface TranslateRule {
    match(givenNumber: number): boolean;
    translateNumber(givenNumber: number): string;
}

export class FizzRule implements TranslateRule {
    match(givenNumber: number): boolean {
        return givenNumber%3 == 0;
    }
    translateNumber(): string {
        return "Fizz";
    }
}

export class BuzzRule implements TranslateRule {
    match(givenNumber: number): boolean {
        return givenNumber%5 == 0;
    }
    translateNumber(): string {
        return "Buzz";
    }
}

export class FizzBuzzRule implements TranslateRule {
    match(givenNumber: number): boolean {
        return givenNumber%15 == 0;
    }
    translateNumber(): string {
        return "FizzBuzz"
    }
}
