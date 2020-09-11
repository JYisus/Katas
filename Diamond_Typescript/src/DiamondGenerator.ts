class DiamondGenerator {
    constructor(private InitialLetter: string) {}

    generate(maxLetter: string): string {
        if (maxLetter == "") return "";

        if (maxLetter == "A") return this.generateLine(maxLetter,maxLetter);

        let diamondLength: number = maxLetter.charCodeAt(0) - this.InitialLetter.charCodeAt(0);
        let detachedString: string[] = [];
        for (let i=0; i<(diamondLength); i++) {
            // console.log(this.generateLine(String.fromCharCode(this.InitialLetter.charCodeAt(0)+i),maxLetter));
            detachedString.push(this.generateLine(String.fromCharCode(this.InitialLetter.charCodeAt(0)+i),maxLetter));
        }

        let reverseDetachedString: string[] = [...detachedString];
        reverseDetachedString = reverseDetachedString.reverse();
        detachedString.push(this.generateLine(maxLetter,maxLetter));
        detachedString = detachedString.concat(reverseDetachedString);
        return detachedString.join("\n");

        // return `${this.generateLine("A",maxLetter)}\n${this.generateLine(maxLetter,maxLetter)}\n${this.generateLine("A",maxLetter)}`
    }

    generateLine(letter: string, maxLetter: string) {
        let letterValue: number = letter.charCodeAt(0);
        let maxLetterValue: number = maxLetter.charCodeAt(0);
        let spaceFromLetterToMaxLetter: number = maxLetterValue - letterValue;

        if (letter == "A") {
            return `${" ".repeat(spaceFromLetterToMaxLetter)}${letter}`
        }

        let initalLetterValue: number = this.InitialLetter.charCodeAt(0);
        let spacesBetweenLetters: number = 2*letterValue-2*initalLetterValue-1;

        return `${" ".repeat(spaceFromLetterToMaxLetter)}${letter}${" ".repeat(spacesBetweenLetters)}${letter}`;

    }
}

export {
    DiamondGenerator
}