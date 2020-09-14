class DiamondGenerator {
    private InitialASCIIvalue: number;
    constructor(private InitialLetter: string) {
        this.InitialASCIIvalue = InitialLetter.charCodeAt(0);
    }

    generate(maxLetter: string): string {
        if (maxLetter == "") return "";

        if (maxLetter == "A") return this.generateLine(maxLetter,maxLetter);

        const maxASCIIvalue: number = maxLetter.charCodeAt(0);
        const diamondLength: number = maxASCIIvalue - this.InitialASCIIvalue;
        const detachedString: string[] = [];

        for (let i=0; i<(diamondLength); i++) {
            const currentLetter = String.fromCharCode(this.InitialASCIIvalue+i);
            detachedString.push(this.generateLine(currentLetter,maxLetter));
        }

        const reverseDetachedString: string[] = [...detachedString];
        reverseDetachedString.reverse();
        
        detachedString.push(this.generateLine(maxLetter,maxLetter), ...reverseDetachedString);

        return detachedString.join("\n");
    }

    generateLine(letter: string, maxLetter: string) {
        let letterValue: number = letter.charCodeAt(0);
        let maxLetterValue: number = maxLetter.charCodeAt(0);
        let spaceFromLetterToMaxLetter: number = maxLetterValue - letterValue;

        if (letter == "A") {
            return `${" ".repeat(spaceFromLetterToMaxLetter)}${letter}`
        }
        let spacesBetweenLetters: number = 2*letterValue-2*this.InitialASCIIvalue-1;

        return `${" ".repeat(spaceFromLetterToMaxLetter)}${letter}${" ".repeat(spacesBetweenLetters)}${letter}`;

    }
}

export {
    DiamondGenerator
}